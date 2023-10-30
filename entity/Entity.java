package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D; 
import java.awt.Color;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Main.UtilityTool;
import Main.gamePanel;
import entity.npcs.NPC_Pearl_Swindlers; 

import java.awt.AlphaComposite;

public abstract class Entity {
    public int worldX, worldY; 
    public int speed; 
    public String direction; 
    public String filePath; 

    public BufferedImage sprite;  
    public String spriteSheetPath; 
    public BufferedImage portrait; 
    
    public Rectangle hitbox;
    public gamePanel jz;  

    public int spriteWidth;
    public int spriteHeight;

    public Entity currentEntity; 
    public Entity collidedEntity;

    public boolean barkSoundPlayed = false; 

    protected Color transParent = new Color(255, 0, 0, 0); 

    public String portraitFilepath;

    protected String dialogues[] = new String[20]; 
    public String entName; 

    public Graphics2D g2; 

    protected int dialogueIndex = 0; 

    // ENTITY AGGRESSION 
    public int aggroState; 
    public final int neutralAggro = 0; 
    public final int hostileAggro = 1;
    public final int passiveAggro = 2; 

    // ENTITY STATUS 
    public boolean isAlive; 
    public boolean isDying;
    public int statusMin = 0; 

    public int maxHealth;
    public int health;

    public int maxMana;
    public int mana;

    public int maxStamina;
    public int stamina; 

    // ENTITY STATS 
    public int strength;
    public int intelligence; 
    public int sleight; 
    public int soul; 
    public int constitution; 
    public int charm;
    public int luck; 

    // ENTITY OFFENSIVE COMBAT STATS 
    public int atkDmg;
    public int atkDmgRange; 
    public double hitChance; 

    public int critHitAtkDmg; 
    public double critHitChance;

    public int wound; 
    public double woundChance; 

    public int piercing;
    public double piercingChance;

    // ENTITY DEFENSIVE COMBAT STATS 
    public int defVal; 
    public double dodgeChance;
        // RESISTANCES 



    public boolean isInvincible = false;
    public boolean isAttacking = false; 

    // COUNTERS 
    public int invincibleCounter = 0; 
    public int attackingCounter = 0; 
    public int dyingCounter = 0; 
    public int actionLockCounter = 0;

    public Entity(gamePanel jz) {
        this.jz = jz; 
        spriteWidth = 64; 
        spriteHeight = 64; 
        speed = 4; 

        isAlive = true;
        isDying = false; 

        aggroState = neutralAggro; 
        hitbox = new Rectangle(this.worldX, this.worldY, this.spriteWidth, this.spriteHeight);

        // entName = getName();
        // portraitFilepath = getPortraitFilepath(); 
        setEntDefaultValues(); 
    }

    public void setEntDefaultValues() {
        strength = 25; 
        intelligence = 25; 
        sleight = 25; 
        soul = 25; 
        constitution = 25; 
        charm = 25; 
        luck = 25;    
    }

    public void setAction(int speed) {
        actionLockCounter++;
        if (actionLockCounter == 60) {
            Random random = new Random();
            int i = random.nextInt(4); // Generate a random number between 0 and 3
            int tileSize = jz.tileSize; 
    
            switch (i) {
                case 0: // Move up
                    if (worldY - tileSize >= 0) {
                        this.direction = "up";
                        worldY -= tileSize / speed;
                    }
                    break;
                case 1: // Move down
                    if (worldY + tileSize < jz.screenHeight * tileSize) {
                        this.direction = "down";
                        worldY += tileSize / speed;
                    }
                    break;
                case 2: // Move left
                    if (worldX - tileSize >= 0) {
                        this.direction = "left";
                        worldX -= tileSize / speed;
                    }
                    break;
                case 3: // Move right
                    if (worldX + tileSize < jz.screenWidth * tileSize) {
                        this.direction = "right";
                        worldX += tileSize / speed;
                    }
                    break;
            }
    
            actionLockCounter = 0;
        }
    }

    public void mobAttack() {
        if (jz.player.isInvincible == false) {
            double chance = Math.random();

            if (chance < this.getHitChance(this.sleight, this.stamina, this.luck)) {
                System.out.println("chance: " + chance + "Hit chance:" + this.getHitChance(this.sleight, this.stamina, this.luck));
                jz.player.health -= this.getAtkDmg(this.atkDmg, this.atkDmgRange);
                jz.player.isInvincible = true;
                jz.sound.playHitSound();
            }
            else {
              // jz.sound.playMissSound();
            }
        }
    }

    public void damageReaction() {
        actionLockCounter = 0; 
        direction = jz.player.direction; 
    }

    public void update() {
        Entity currentEntity = this; 
        currentEntity.setAction(speed);
        currentEntity.updateHitbox(worldX, worldY);
        if (currentEntity.collidesWith(jz.player) && currentEntity instanceof NPC_Pearl_Swindlers && !barkSoundPlayed) { 
            jz.sound.playBarkSound(); 
            barkSoundPlayed = true; 
        }
         else if (currentEntity.collidesWith(jz.player) && jz.keys.chatterPress) { 
            jz.gameState = jz.dialogueState; 
        } 
        if (isInvincible) {
            invincibleCounter++;
            if (invincibleCounter > 15) {
                isInvincible = false; 
                invincibleCounter = 0; 
            }
        }
    }

    public Entity getCurrentEntity() {
        return currentEntity; 
    }

    public void getSprite(String filePath) {
        sprite = setup(filePath); 
    }

    public void getPortraitFilepath(String filePath) {
        portraitFilepath = filePath;
    }

    public void getName(String entityName) {
        entName = entityName; 
    }

    public int getAtkDmg(int atkDmg, int atkDmgRange) {
        int minDmg = atkDmg - atkDmgRange / 2;
        int maxDmg = atkDmg + atkDmgRange / 2;
        
        return getRandomDamage(minDmg, maxDmg); 
    }

    public double getHitChance(int sleight, int stamina, int luck) {
        double hitChance = (sleight * 0.5) + (stamina * 0.2) + (luck * 0.1);

        hitChance = Math.max(0, Math.min(100, hitChance));
        
        return hitChance / 100; 
    }
    
    private int getRandomDamage(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void speak() {

    }

    public void updateHitbox(int newX, int newY) {
        this.worldX = newX;
        this.worldY = newY;
        this.hitbox.setLocation(newX, newY);
    }

    public boolean collidesWith(Entity otherEntity) {
        
        if (jz.gameState == jz.dialogueState) {
            return false;
        }

        return this.hitbox.intersects(otherEntity.hitbox);
    }
    public void draw(Graphics2D g2, gamePanel jz) {
        int playerWorldX = jz.player.worldX;
        int playerWorldY = jz.player.worldY;
        int playerScreenX = jz.player.screenX;
        int playerScreenY = jz.player.screenY;
        int tileSize = jz.tileSize;
        int radius = jz.player.radius;
    
        int screenX = worldX - playerWorldX + playerScreenX;
        int screenY = worldY - playerWorldY + playerScreenY;
    
        // Calculate the distance from the center of the circle
        int centerX = jz.screenWidth / 2;
        int centerY = jz.screenHeight / 2;
        int dxFromCenter = screenX + spriteWidth / 2 - centerX;
        int dyFromCenter = screenY + spriteHeight / 2 - centerY;
        double distanceFromCenter = Math.sqrt(dxFromCenter * dxFromCenter + dyFromCenter * dyFromCenter);
    
        if (distanceFromCenter <= radius * tileSize) {
            // The entity is within the specified radius
    
            if (screenX + spriteWidth > 0 &&
    screenX < jz.screenWidth &&
    screenY + spriteHeight > 0 &&
    screenY < jz.screenHeight) {

    // Calculate transparency based on distance
    float transparency = 1.0f; // Default: fully opaque
    if (distanceFromCenter > radius * tileSize) {
        float alphaFactor = (float) ((distanceFromCenter - (radius * tileSize)) / (radius * tileSize));
        transparency -= alphaFactor; // Gradually reduce transparency
    }

    // Create an AlphaComposite with the specified transparency
    AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
    g2.setComposite(alphaComposite);

    // Draw the entity
    g2.drawImage(sprite, screenX, screenY, spriteWidth, spriteHeight, null);
    
    g2.setColor(jz.jzUI.gillRed);
    if (entName != null  && jz.gameState == jz.dialogueState) {
        g2.drawString(entName, 100, 100);
        System.out.println(entName);

    }

    if (isInvincible) {
        g2.drawImage(invert(sprite), screenX, screenY, spriteWidth, spriteHeight, null);
    }

    if (isAttacking) {
        g2.drawImage(saturate(sprite), screenX, screenY, spriteWidth, spriteHeight, null);
    }

    if (jz.keys.controlPress) {
        g2.setColor(jz.jzUI.gillRed);
        g2.fillRoundRect(screenX - 4, screenY - 15, this.maxHealth + 4, 16, 15, 15);

        g2.setColor(jz.jzUI.pussyPink);
        g2.fillRoundRect(screenX, screenY - 15 + 4, this.maxHealth, 8, 15, 15); 

        g2.setColor(jz.jzUI.sanguinePrincess);
        g2.fillRoundRect(screenX, screenY - 15 + 4, this.health, 8, 15, 15); 
    }


    // Reset the composite to fully opaque
    g2.setComposite(AlphaComposite.SrcOver);
            }
        }
    }
    
    public static BufferedImage invert(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage invertedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // Use BufferedImage.TYPE_INT_ARGB instead of BufferedImage.TYPE_INT_RGB
    
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xFF; // Extract the alpha channel value
    
                // If the alpha channel is already 0, no need to invert the color
                if (alpha == 0) {
                    invertedImage.setRGB(x, y, rgb);
                } else {
                    // Invert the color components while preserving the alpha channel
                    int invertedRGB = (alpha << 24) | ((255 - (rgb >> 16) & 0xFF) << 16) | ((255 - (rgb >> 8) & 0xFF) << 8) | (255 - (rgb & 0xFF));
                    invertedImage.setRGB(x, y, invertedRGB);
                }
            }
        }
    
        return invertedImage;
    }
    

public static BufferedImage saturate(BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    float saturationFactor = 2.0f; 
    BufferedImage saturatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    float[] hsv = new float[3];

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            Color originalColor = new Color(image.getRGB(x, y));
            Color.RGBtoHSB(originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue(), hsv);

            float saturation = hsv[1] * saturationFactor;
            saturation = Math.min(saturation, 1.0f);

            int rgb = Color.HSBtoRGB(hsv[0], saturation, hsv[2]);
            saturatedImage.setRGB(x, y, rgb);
        }
    }

    return saturatedImage;
}

    public BufferedImage setup(String filePath) {
        UtilityTool uTool = new UtilityTool(); 
        BufferedImage scaledImage = null; 

        try {
            scaledImage = ImageIO.read(getClass().getResourceAsStream(filePath));
            scaledImage = uTool.scaleImage(scaledImage, spriteWidth, spriteHeight); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scaledImage; 
    }
}
