package Main; 

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class AnimationManager {
    public BufferedImage currentFrame; 
    public int currentFrameInt = 0; 
    public int frameWidth;
    public int frameHeight;
    public int frameDuration;
    public int totalFrames; 
    public int fps;

    public AnimationManager () {
        totalFrames = 8; 
        fps = 4; 
        frameDuration = 1000 / fps;

        /*try {
            // BufferedImage spriteSheet = ImageIO.read(new File(filePath));
           // BufferedImage[] sprites = extractSprites(spriteSheet, frameWidth, frameHeight);
        } catch (IOException e) {
            e.printStackTrace();
        } */
    }

}