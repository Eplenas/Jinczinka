package object;

import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.UtilityTool;
import Main.gamePanel; 

public class SuperObject {
    public BufferedImage image; 
    public String name; 
    public boolean collision = false; 
    public boolean isDrawn = false; 
    public int worldX, worldY; 
    public int width = 64;
    public int height = 64;
    UtilityTool uTool = new UtilityTool(); 

    public void draw(Graphics2D g2, gamePanel jz) {
        int screenX = worldX - jz.player.worldX + jz.player.screenX;
        int screenY = worldY - jz.player.worldY + jz.player.screenY;
    
        if (isWithinPlayerView(screenX, screenY, jz)) {
            g2.drawImage(image, screenX, screenY, width, height, null);
        }
    }
    
    private boolean isWithinPlayerView(int screenX, int screenY, gamePanel jz) {
        int minX = -jz.tileSize;
        int minY = -jz.tileSize;
        int maxX = jz.screenWidth;
        int maxY = jz.screenHeight;
    
        return screenX >= minX && screenX < maxX && screenY >= minY && screenY < maxY;
    }

    public void getObject(String filePath) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(filePath));
        } catch(IOException e) {
            System.err.println(e);
        }
    }
}

