/* package Main; 

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AnimationTool {
    public BufferedImage[] frames;
    public BufferedImage currentFrame; 
    public int currentFrameInt = 0; 
    public int frameWidth;
    public int frameHeight;
    public int frameDuration;
    public int totalFrames; // 8 
    public int fps; // 4

    public AnimationTool(String filePath, int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        totalFrames = 8; 
        fps = 4; 
        frameDuration = 1000 / fps;

        try {
            BufferedImage spriteSheet = ImageIO.read(new File(filePath));
            frames = extractSprites(spriteSheet, frameWidth, frameHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage[] extractSprites(BufferedImage spriteSheet, int frameWidth, int frameHeight) {
        int rows = spriteSheet.getHeight() / frameHeight;
        int columns = spriteSheet.getWidth() / frameWidth;

        BufferedImage[] sprites = new BufferedImage[totalFrames];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int spriteIndex = i * columns + j;
                sprites[spriteIndex] = spriteSheet.getSubimage(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
            }
        }

        return sprites;
    }

    public void animate(BufferedImage[] sprites) {
        for (int i = 0; i < sprites.length; i++) {
            currentFrame = sprites[i]; 
            currentFrameInt++;
            System.out.println(currentFrameInt);

            try {
                Thread.sleep(frameDuration); 
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
    }
} */ 

package Main; 

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 

public class AnimationTool {
    public AnimationTool() {

    }

    public BufferedImage[] animate(String filePath) {
        int numFrames = 8; 
        BufferedImage[] sprites = new BufferedImage[numFrames]; 

        for (int i = 0; i <= 7; i++) {
            String currentFilePath = filePath + i + ".png";

            try {
                BufferedImage sprite = ImageIO.read(new File(currentFilePath));
                sprites[i - 0] = sprite; 
            } catch (IOException e) {
                e.printStackTrace(); 
            }
        }
        return sprites; 
    }

}
