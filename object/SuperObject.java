package object;

import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.UtilityTool;
import Main.gamePanel; 

public abstract class SuperObject {
    public BufferedImage image; 
    public String name; 
    public boolean collision = false; 
    public boolean isDrawn = false; 
    public int worldX, worldY; 
    public int width = 64;
    public int height = 64;
    UtilityTool uTool = new UtilityTool(); 

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
        int dxFromCenter = screenX + width / 2 - centerX;
        int dyFromCenter = screenY + height / 2 - centerY;
        double distanceFromCenter = Math.sqrt(dxFromCenter * dxFromCenter + dyFromCenter * dyFromCenter);
    
        if (distanceFromCenter <= radius * tileSize) {
            // The object is within the circular radius
    
            if (screenX + width > 0 &&
                screenX < jz.screenWidth &&
                screenY + height > 0 &&
                screenY < jz.screenHeight) {
    
                // Draw the object
                g2.drawImage(image, screenX, screenY, width, height, null);
    
                // Additional drawing logic here
    

            }}
        }

    public void getObject(String filePath) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(filePath));
        } catch(IOException e) {
            System.err.println(e);
        }
    }
}

