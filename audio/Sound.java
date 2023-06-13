package audio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sound {
    private ExecutorService soundPool;
    
    public Sound() {
        soundPool = Executors.newCachedThreadPool();
    }

    public void playHitSound() {
        playSound("/r/resources/sound/squidAttack.mp3");
    }

    public void playDeathSound() {
        playSound("/r/resources/sound/deathCrackle.mp3");
    }

     public void playMissSound() {
        playSound("/r/resources/sound/attackMiss.mp3");
    } 

    public void playBarkSound() {
        playSound("/r/resources/sound/swindlerBark.mp3");
    }

    public void playSound(String soundFile) {
        soundPool.execute(() -> {
            AdvancedPlayer player = null;
            try (InputStream is = Sound.class.getResourceAsStream(soundFile)) {
                player = new AdvancedPlayer(is);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (player != null) {
                    player.close();
                }
            }
        });
    }

    public void stop() {
        soundPool.shutdownNow();
    }
}
