package Main;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Toolkit; 
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent; 

import entity.*;
import entity.npcs.NPC_Pearl_Swindlers;
import audio.*;
import object.SuperObject;
import tile.MapGenerator;
import tile.TileManager; 

public class gamePanel extends JPanel implements Runnable {

    Color overlay = new Color(0, 128, 135);

    // SCREEN SETTINGS
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    
    final public int originalTileSize = 32; // 32x32px tiles 
    final int scale = 2; 

    final public int tileSize = originalTileSize * scale; 
    final public int maxScreenCol = 30; 
    final public int maxScreenRow = 16; 

    public int screenWidth = maxScreenCol * tileSize;
    public int screenHeight = maxScreenRow * tileSize;

    // WORLD SETTINGS
    final public int maxWorldCol = 50; 
    final public int maxWorldRow = 50; 
    final public int worldWidth = tileSize * maxWorldCol;
    final public int worldHeight = tileSize * maxWorldRow;
    
    // FPS
    int FPS = 60; 

    TileManager tileM = new TileManager(this); 
    public KeyHandler keys = new KeyHandler(this);
    public EventHandler events = new EventHandler(this); 
    Thread gameThread;  
    Thread userInputThread;
    public AssetSetter assSetter = new AssetSetter(this); 
    public UI jzUI;  
    public MapGenerator mapGen = new MapGenerator(this);
    // public Scanner scanner = new Scanner(System.in); 
    public StringBuffer userInput = new StringBuffer(); 
    public Sound sound = new Sound();

    // ENTITIES AND OBJECTS 
    public Player player = new Player(this, keys); 
    public ArrayList<SuperObject> obj = new ArrayList<>();
    public ArrayList<Entity> npcs = new ArrayList<>();
    public ArrayList<Entity> mobs = new ArrayList<>();

    // GAME STATE 
    public int gameState; 
    public final int titleState = 0; 
    public final int playState = 1; 
    public final int pauseState = 2; 
    public final int dialogueState = 3; 
    public final int bookState = 4; 
    public final int deathState = 5; 
    public final int characterState = 6;  

    public long playStateStartTime; 

    GameTimer gameTimer = new GameTimer();
    String saveFileName = "s/saves/elapsed_time.txt";

    long elapsedTimeMillis = gameTimer.getElapsedTimeInMilliseconds();
    long elapsedTimeSeconds = gameTimer.getElapsedTimeInSeconds();
    long elapsedTimeMinutes = gameTimer.getElapsedTimeInMinutes();

    // SET PLAYERS DEFAULT POSITION 
    int playerX = 100; 
    int playerY = 100; 
    int playerSpeed = 4;
    public String inputText;

    Animation animation = Animation.createAnimation("r/resources/sprites/npcs/flanSpriteSheet.png", 32, 48);

    public gamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setLayout(null); 
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.add(keys); 
        jzUI = new UI(this); 
    }

    public void setUpGame() {
        assSetter.setObject();
        assSetter.setNPC(); 
        assSetter.setMob();
        mapGen.generateMap();
        gameState = titleState;
    }


    

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        playStateStartTime = System.currentTimeMillis();
    }

    public void startUserInputThread() {
        userInputThread = new Thread(this);
        
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (gameState == dialogueState && keys.acceptUserInput && e.getKeyChar() == '\b') {
                    // Backspace key is typed, remove the last character from userInput
                    synchronized (jzUI.userInput) {
                        if (jzUI.userInput.length() > 0) {
                            jzUI.userInput.deleteCharAt(jzUI.userInput.length() - 1);
                        }
                    }
                } else if (gameState == dialogueState && keys.acceptUserInput) {
                    // Handle other key typed events
                    char c = e.getKeyChar();
                    synchronized (jzUI.userInput) {
                        jzUI.userInput.append(c);
                    }
                }
            }
    
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameState == dialogueState && e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    synchronized(jzUI.userInput) {
                        if (jzUI.userInput.length() > 0) {
                            jzUI.userInput.deleteCharAt(jzUI.userInput.length() - 1); 
                        }
                    }
                }
    
            }
    
            @Override
            public void keyReleased(KeyEvent e) {
    
            }
        });
        
        this.setFocusable(true);
        this.requestFocusInWindow();
    
        userInputThread.start();
        System.out.println("Ready to accept user input");
    }


   // GAME LOOP
@Override 
public void run() {
    int sec = 1000000000; // 1 billion nanoseconds / 1 second
    double updateInterval = sec / FPS;  // Desired update interval in nanoseconds
    double drawInterval = sec / FPS;    // Desired draw interval in nanoseconds
    double deltaUpdate = 0;
    double deltaDraw = 0;
    long lastUpdateTime = System.nanoTime();
    long lastDrawTime = System.nanoTime();
    long currentTime; 

    long timer = 0;
    int drawCount = 0;

    while (gameThread != null) {

        gameTimer.start();

        currentTime = System.nanoTime();

        deltaUpdate += (currentTime - lastUpdateTime) / updateInterval;
        deltaDraw += (currentTime - lastDrawTime) / drawInterval;
        timer += (currentTime - lastDrawTime);

        lastUpdateTime = currentTime; 
        lastDrawTime = currentTime;

        if (deltaUpdate >= 1) {
            // 1] UPDATE
            update();
            // System.out.println("Current game state: " + gameState);
            deltaUpdate--; // Resets deltaUpdate
        }

        if (deltaDraw >= 1) {
            // 2] DRAW 
            repaint(); // paintImmediately ? 
            deltaDraw--; // Resets deltaDraw
            drawCount++;
        }

        // Resets every second to display the FPS 
        if (timer >= sec) {
            System.out.println("FPS:" + drawCount);
            drawCount = 0;
            timer = 0; 
        }

        // Introduce a small delay to slow down the loop
        try {
            Thread.sleep(10); // Adjust the sleep duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    public void update() {
        if (gameState == playState) {
            // PLAYER
            player.update();
            gameTimer.updateElapsedTime();
            gameTimer.saveElapsedTime(saveFileName);
            // NPC
            for (int i = 0; i < npcs.size(); i++) {
                if (npcs.get(i) != null) {
                    npcs.get(i).update();
                        }
            }
            for (int i = 0; i < mobs.size(); i++) {
                if (mobs.get(i) != null) {
                    mobs.get(i).update();
                     if (mobs.get(i).collidesWith(player) && mobs.get(i) instanceof NPC_Pearl_Swindlers) {
                        sound.playBarkSound();
                    }
                    else if (mobs.get(i).collidesWith(player)) {
                        player.damageMob(i);
                        mobs.get(i).mobAttack();
                    }
                }
            }
        }
        if (gameState == pauseState || gameState == titleState || gameState == characterState) {
            gameTimer.pause(); 
            gameTimer.saveElapsedTime(saveFileName);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; 

        // DEBUG
        long drawStart = 0; 
        if (keys.checkDrawTime == true) {
            drawStart = System.nanoTime(); 
        }
        // TITLE SCREEN
        if (gameState == titleState || gameState == pauseState) {
            jzUI.draw(g2);
        }

        // OTHER ELEMENTS 
        else {
            // BACKGROUND TILES
            tileM.render(g2);

            // OBJECTS 
            for (int i = 0; i < obj.size(); i++) {
                if (obj.get(i) != null) {             
                    obj.get(i).draw(g2, this);
                }
            }
            // COLOR OVERLAY 
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.215f));
            g2.setColor(overlay); // dark teal
            g2.fillRect(0, 0, screenWidth, screenHeight);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

            // NPCS
            for (int i = 0; i < npcs.size(); i++) {
                if (npcs.get(i) != null) {
                   npcs.get(i).draw(g2, this);
                }
            }

            // MOBS 
            for (int i = 0; i < mobs.size(); i++) {
                if (mobs.get(i) != null) {
                    mobs.get(i).draw(g2, this);
                }
            }

            // PLAYER 
            player.draw(g2);

            // UI
            jzUI.draw(g2);

            if (gameState != titleState || gameState != characterState) {
                // Assuming you have an 'animation' object
                animation.update();
                BufferedImage currentFrameImage = animation.getImage();
                int animationX = tileSize * 5;
                int animationY = tileSize * 5;
        
                // Render the current frame image to the screen
                g2.drawImage(currentFrameImage, animationX, animationY, null);
            }
        
        }
        
        if (keys.checkDrawTime == true) {
            long drawEnd = System.nanoTime(); 
            long passed = drawEnd - drawStart; 
            double passedSec = (double)passed / 1000000000.0; 
             System.out.println("Draw time: " + passedSec); 
        }

        g2.dispose(); 
    }

}


