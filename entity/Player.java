package entity; 

import Main.gamePanel; 
import Main.KeyHandler; 

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.AlphaComposite;

public class Player extends Entity {

    gamePanel jz; 
    KeyHandler keys; 

    public final int screenX;
    public final int screenY;

    protected Color gillRed = new Color(96, 22, 54); 

    public boolean playerIsStill;

    public int actionLockCounter = 0; 
    public int radius; 

    public Player(gamePanel jz, KeyHandler keys) {
        super(jz); 
        this.jz= jz; 
        this.keys = keys;
        
        this.health = 100; 
        this.mana = 100;
        this.stamina = 100;
        
        playerIsStill = true;

        screenX = jz.screenWidth / 2 - (jz.tileSize / 2); 
        screenY = jz .screenHeight / 2 - (jz.tileSize / 2); 

        setDefaultValues();
        this.getSprite("/r/resources/sprites/player/playerSpriteHurt.png", "/r/resources/sprites/player/playerSpriteHurt.png", "r/resources/sprites/player/playerSpriteAttack.png"); 
    }

    public void setDefaultValues() {
        worldX = jz.tileSize * 8;
        worldY = jz.tileSize * 6;
        speed = 2;  

        // PLAYER STATUS 
        maxHealth = 112; 
        health = maxHealth; 
        
        maxMana = 112;
        mana = maxMana;

        maxStamina = 112;
        stamina = maxStamina; 

        atkDmg = 10; 
        atkDmgRange = 4; 

       strength = 25; 
       intelligence = 25; 
       sleight = 25; 
       soul = 25; 
       constitution = 25; 
       charm = 25; 
       luck = 25; 

       radius = 7; 
    }

    @Override
    public void update() { 
            if(keys.upPress == true && worldY - jz.tileSize >= 0) {
                this.direction = "up"; 
                worldY -= speed; 
                playerIsStill = false;
            }
            if (keys.downPress == true && worldY + jz.tileSize >= 0) {
                this.direction = "down"; 
                worldY += speed;
                playerIsStill = false;

            }
            if (keys.leftPress == true && worldX - jz.tileSize >= 0) {
                this.direction = "left"; 
                worldX -= speed;
                playerIsStill = false;

            }
            if (keys.rightPress == true && worldX + jz.tileSize >= 0) {
                this.direction = "right"; 
                worldX += speed;
                playerIsStill = false;

            }

            if (!keys.upPress && !keys.downPress && !keys.leftPress && !keys.rightPress) {
                playerIsStill = true;
            }

            updateHitbox(worldX, worldY); 
           // System.out.println("Player hitbox X: " + worldX + "Y: " + worldY);

           jz.events.checkEvent();
        
           if (isInvincible == true) {
              invincibleCounter++;
              if (invincibleCounter > 60) {
                isInvincible = false; 
                invincibleCounter = 0; 
              }
           }

           if (isAttacking == true) {
            attackingCounter++;
            if (attackingCounter > 60) {
              isAttacking = false; 
              attackingCounter = 0; 
            }
         }

           if (this.health <= 0) {
                jz.gameState = jz.deathState;
                jz.sound.playDeathSound(); 
           }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(sprite, screenX, screenY, spriteWidth, spriteHeight, null);
        
        if (isInvincible) {
            g2.drawImage(invert(sprite), screenX, screenY, spriteWidth, spriteHeight, null);   
        }

        if (isAttacking) {
            g2.drawImage(saturate(sprite), screenX, screenY, spriteWidth, spriteHeight, null); 
        }

    }

    public void damageMob (int i) {
        if (jz.mobs.get(i).isInvincible == false) {
                jz.mobs.get(i).health -= this.getAtkDmg(atkDmg, atkDmgRange); 
                jz.mobs.get(i).isInvincible = true;
                jz.mobs.get(i).damageReaction();
                System.out.println(jz.mobs.get(i).health);
                if (jz.mobs.get(i).health <= 0 ) {
                    jz.mobs.get(i).isDying = true; 
                    jz.mobs.remove(i); 
                }
        }
       /*  else {
            jz.sound.playHitSound();
            this.health -= jz.mobs.get(i).attackDamage;
            this.isInvincible = true; 
        } */
    }
}