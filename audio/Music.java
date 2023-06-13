package audio;


import Main.KeyHandler; 
import Main.gamePanel; 

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.InputStream;
import java.util.Random;

public class Music {
    
    private AdvancedPlayer player;
    private Random random = new Random();
    private gamePanel jz = new gamePanel(); 
    private KeyHandler keys = new KeyHandler(jz); 

    String[] musicFiles;

    public Music(String[] musicFiles) {
        this.musicFiles = musicFiles; 
    }

    public boolean startMusic() {
        return true; 
    }

    public boolean endMusic() {
         if(keys.mutePress == true) {
            return true; 
        } 
        else return false;  
    }

    public void update() {
        if (startMusic() == true) {
            play(); 
        }
        else stop(); 
    }

    public void play() {
        try {
            int randomIndex = random.nextInt(musicFiles.length);
            String musicFile = musicFiles[randomIndex];
            InputStream is = Music.class.getResourceAsStream(musicFile);
            
            if (is == null) {
                System.err.println("Failed to load music file: " + musicFile);
                return;
            }
            
            player = new AdvancedPlayer(is);
            player.play();
    
            int delay = random.nextInt(16000) + 5000;
            Thread.sleep(delay);
        } catch (ArrayIndexOutOfBoundsException | JavaLayerException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (player != null) {
                player.close();
            }
        }
    }

    public void stop() {
        player.close();
    }
}
