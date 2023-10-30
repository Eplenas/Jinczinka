package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Animation {

    private BufferedImage[] frames;
    private int currentFrame;
    private int numFrames;

    private int count;
    private int delay;

    private int timesPlayed;

    public Animation(BufferedImage[] frames) {
        timesPlayed = 0;
        setFrames(frames);
    }

    public Animation() {
        timesPlayed = 0;
    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        count = 0;
        timesPlayed = 0;
        delay = 12;
        numFrames = frames.length;
    }

    public void setDelay(int i) {
        delay = i;
    }

    public void setFrame(int i) {
        currentFrame = i;
    }

    public void setNumFrames(int i) {
        numFrames = i;
    }

    public void update() {
        if (delay == -1)
            return;

        count++;
        if (count == delay) {
            currentFrame++;
            count = 0;
        }
        if (currentFrame == numFrames) {
            currentFrame = 0;
            timesPlayed++;
        }
    }

    public int getDelay() {
        return delay;
    }

    public int getFrame() {
        return currentFrame;
    }

    public int getCount() {
        return count;
    }

    public BufferedImage getImage() {
        return frames[currentFrame];
    }

    public boolean hasPlayedOnce() {
        return timesPlayed > 0;
    }

    public boolean hasPlayed(int i) {
        return timesPlayed == i;
    }

    public List<BufferedImage> extractSprites(String spriteSheetPath, int frameWidth, int frameHeight) {
        List<BufferedImage> frames = new ArrayList<>();
        try {
            BufferedImage spriteSheet = ImageIO.read(new File(spriteSheetPath));
            int rows = spriteSheet.getHeight() / frameHeight;
            int columns = spriteSheet.getWidth() / frameWidth;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int x = j * frameWidth;
                    int y = i * frameHeight;
                    System.out.println("Extracting frame at position (" + x + ", " + y + ")");
                    
                    BufferedImage frame = spriteSheet.getSubimage(x, y, frameWidth, frameHeight);
            
                    if (!isFrameBlank(frame)) {
                        frames.add(frame);
                    }
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Frames extracted: " + frames.size());
        return frames;
    }

    // Helper method to check if a frame is blank (fully transparent)
    private boolean isFrameBlank(BufferedImage frame) {
        for (int x = 0; x < frame.getWidth(); x++) {
            for (int y = 0; y < frame.getHeight(); y++) {
                int alpha = (frame.getRGB(x, y) >> 24) & 0xFF;
                if (alpha != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Create an animation from a sprite sheet
    public static Animation createAnimation(String spriteSheetPath, int frameWidth, int frameHeight) {
        Animation animation = new Animation();
        List<BufferedImage> frames = animation.extractSprites(spriteSheetPath, frameWidth, frameHeight);
        animation.setFrames(frames.toArray(new BufferedImage[0]));
        return animation;
    }
}
