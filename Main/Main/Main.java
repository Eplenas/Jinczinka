package Main;

import javax.swing.JFrame;

import audio.Music; 

public class Main {

    public static void main (String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Jinczinka");

        gamePanel jzPanel = new gamePanel(); 
        Music music = new Music(new String[] {
        "/r/resources/music/dive.mp3",
        "/r/resources/music/ekmans_spiral.mp3",
        "/r/resources/music/hymn_of_the_decapods.mp3",
        "/r/resources/music/lily.mp3", 
         "/r/resources/music/seabed.mp3",
        "r/resources/music/schooling.mp3",
        "/r/resources/music/shimmer.mp3",
        "/r/resources/music/submarine_soundbeams.mp3",
        "/r/resources/music/submarine_soundbeams.mp3",
        }); 

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(jzPanel); 

        window.pack(); 

        System.setProperty("sun.java2d.opengl", "true"); 

       jzPanel.setUpGame(); 

       jzPanel.startGameThread(); 
       jzPanel.startUserInputThread();

       music.update();
    }
} 