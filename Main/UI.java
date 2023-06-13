package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.databind.*;

import java.awt.AlphaComposite;
import java.awt.Shape;
import java.awt.Rectangle; 
import java.awt.FontMetrics;

import object.*; 
import entity.*; 

public class UI {
    gamePanel jz; 
    Graphics2D g2;
    Font jzFont; 
    BufferedImage kelpImage; 
    public boolean msgOn = false; 
    public String msg = ""; 
    public int msgCounter = 0; 
    public boolean jzExit = false; // make a "pause screen" upon clicking esc 
    public String currentDialogue = ""; 
    public StringBuffer userInput = new StringBuffer(); 
    public String userInputString = ""; 
    public KeyHandler keys; 

    // TRANSPARENT
    protected Color transParent = new Color(255, 0, 0, 0); 

    // REDS
    public Color gillRed = new Color(96, 22, 54); 
    public Color sanguinePrincess = new Color(159, 53, 31); 
    public Color pussyPink = new Color(249, 121, 121);

    // GREENS
    protected Color kelpChartreuse = new Color(108, 121, 25);
    protected Color cumGreen = new Color(150, 175, 43);
    protected Color limeLime = new Color(215, 209, 49); 

    // BLUES 
    protected Color salkahCyan = new Color(78, 155, 174);
    protected Color salkahCyanDark = new Color(54, 107, 129);
    protected Color salkahCyanDarker = new Color(22, 51, 67);
    
    // PURPLES
    protected Color eggplantPurple = new Color(95, 51, 78); 
    protected Color midLavender = new Color(111, 85, 118); 

    // public BufferedImage portraitTest;

    public Entity cEnt = new Entity(jz); 

    public int totalLines = 0; 

    public UI(gamePanel jz) {
        this.jz = jz;
        OBJ_Kelp1 kelp = new OBJ_Kelp1();
        kelpImage = kelp.image;
        userInput.setLength(0);
        InputStream is = getClass().getResourceAsStream("/r/resources/fonts/MonoAManoRegular-45jx.ttf");
        try {
            jzFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    
    public void showMessage(String text) {
        msg = text; 
        msgOn = true; 

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2; 
        g2.setFont(jzFont); 
        g2.setColor(gillRed);
    
        // TITLE STATE
        if (jz.gameState == jz.titleState) {
            drawTitleScreen();
        }
    
        // PAUSE STATE 
        else if (jz.gameState == jz.pauseState) {
            drawPauseScreen();
        }
    
        // DIALOGUE STATE
        else if (jz.gameState == jz.dialogueState) {
            drawDialogueScreen(); 
        }
    
        // BOOK STATE
        else if (jz.gameState == jz.bookState) {
            drawBookScreen(1);  
        }
    
        // DEATH STATE
        else if (jz.gameState == jz.deathState) {
            drawGameOverScreen();
        }
    
        // PLAY STATE 
        else {
            if (msgOn == true) {
                        
                g2.setFont(g2.getFont().deriveFont(30f)); // Set the font first
                FontMetrics fontMetrics = g2.getFontMetrics(); // Retrieve FontMetrics object
                int textWidth = fontMetrics.stringWidth(msg);

                int rectX = jz.screenWidth / 2 - 8;
                int rectY = jz.screenHeight - jz.tileSize - 24;
                int rectWidth = textWidth + 8;
                int rectHeight = fontMetrics.getHeight() + 16;

                g2.setColor(salkahCyanDark);
                g2.fillRoundRect(rectX, rectY, rectWidth, rectHeight, 30, 30);
                g2.setFont(g2.getFont().deriveFont(30f));
                g2.setColor(gillRed);
                g2.drawString(msg, jz.screenWidth / 2, jz.screenHeight - (jz.tileSize)); 
                msgCounter++;
                if(msgCounter > 80) {
                    msgCounter = 0; 
                    msgOn = false; 
                }
            } 
    
            g2.drawString("Kelp nifdsskdhsakhf", 30, 30);
            drawStatusOverlay(jz.tileSize / 2, jz.screenHeight - 80, 128, 16); 
           //  drawCtrlOverlay(1);
        }
    }
    

    public void drawStatusOverlay(int x, int y, int width, int height) {

        // HEALTH
        
        g2.setColor(gillRed); 
        g2.fillRoundRect(x, y, width, height, 15, 15);

        g2.setColor(pussyPink);
        g2.fillRoundRect(x + 8, y + 4, width - 16, height - 8, 15, 15); 

        g2.setColor(sanguinePrincess); 
        g2.fillRoundRect(x + 8, y + 4, jz.player.health, height - 8, 15, 15); 

        BufferedImage heartIcon = null;  
        BufferedImage wingIcon = null; 
        BufferedImage squidIcon = null; 
        try {
            heartIcon = ImageIO.read(getClass().getResourceAsStream("/r/resources/UI/heartIcon2.png"));
            wingIcon = ImageIO.read(getClass().getResourceAsStream("/r/resources/UI/wingIcon.png"));
            squidIcon = ImageIO.read(getClass().getResourceAsStream("/r/resources/UI/squidIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (heartIcon != null && wingIcon != null && squidIcon != null) {
            g2.drawImage(heartIcon, 6, y - 31, 48, 48, null);
            g2.drawImage(squidIcon, 6, y + 16, 32, 32, null);
            g2.drawImage(wingIcon, 6, y + 32, 32, 32, null);
        }

        // MANA 
        g2.setColor(salkahCyanDarker);
        g2.fillRoundRect(x , y + 24, width, height, 15, 15);

        g2.setColor(salkahCyan);
        g2.fillRoundRect(x + 8, y + 28, width - 16, height - 8, 15, 15); 

        g2.setColor(salkahCyanDark); 
        g2.fillRoundRect(x + 8, y + 28, jz.player.mana, height - 8, 15, 15);

        // STAMINA 
        g2.setColor(kelpChartreuse); 
        g2.fillRoundRect(x, y +  48, width, height, 15, 15); 

        g2.setColor(limeLime); 
        g2.fillRoundRect(x + 8, y + 52, width - 16, height - 8, 15, 15);

        g2.setColor(cumGreen);
        g2.fillRoundRect(x + 8, y + 52, jz.player.stamina, height - 8, 15, 15);  

    }

    public void drawCtrlOverlay(int i) {
        int width = 128;
        int height = 16; 
    
      //  if (jz.keys.controlPress) {
            g2.setColor(gillRed);
            g2.fillRoundRect(jz.mobs.get(i).hitbox.x, jz.mobs.get(i).hitbox.y, width, height, 15, 15);

            g2.setColor(pussyPink);
            g2.fillRoundRect(jz.mobs.get(i).hitbox.x + 8, jz.mobs.get(i).hitbox.x + 4, width - 16, height - 8, 15, 15); 
    
            g2.setColor(sanguinePrincess); 
            g2.fillRoundRect(jz.mobs.get(i).hitbox.x + 8, jz.mobs.get(i).hitbox.y + 4, jz.mobs.get(i).health, height - 8, 15, 15); 
        // }
        // g2.dispose();
    } 

    public void drawTitleScreen() {
        int centerX = jz.screenWidth / 2; 
        int centerY = jz.screenHeight / 2; 

        // BACKGROUND
        BufferedImage titleScreen = null;  
        try {
            titleScreen = ImageIO.read(getClass().getResourceAsStream("/r/resources/screens/titleScreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (titleScreen != null) {
            g2.drawImage(titleScreen, 0, 0, jz.screenWidth, jz.screenHeight, null);
        }


        // TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        g2.setColor(pussyPink);
        g2.drawString("Jinczinka", centerX - 128, centerY + (jz.tileSize * 3));

        // MENU 
        g2.setColor(gillRed); 
        g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 40F)); 
        g2.drawString("[enter] play", centerX - jz.tileSize, centerY + jz.tileSize * 4);
        g2.drawString("[esc] exit", centerX - jz.tileSize, centerY + jz.tileSize * 4 + 45); 

    }

    public void drawPauseScreen() {
        BufferedImage pauseScreen = null;  
        try {
            pauseScreen = ImageIO.read(getClass().getResourceAsStream("/r/resources/screens/pauseScreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (pauseScreen != null) {
            g2.drawImage(pauseScreen, 0, 0, jz.screenWidth, jz.screenHeight, null);
        }

        g2.setFont(g2.getFont().deriveFont(50f));
        g2.setColor(pussyPink); 
        g2.drawString(">>>PAUSED<<<", jz.tileSize * 4, jz.tileSize * 3);
        g2.setFont(g2.getFont().deriveFont(30f));
        g2.drawString("There's no rush.", jz.tileSize * 4, jz.tileSize * 3 + 48); 
        g2.drawString("[space] continue", jz.tileSize * 4, jz.tileSize * 5);
        g2.drawString("[esc] leave Jinczinka", jz.tileSize * 4, jz.tileSize * 5 + 48);
    }

    public void drawGameOverScreen() {
        BufferedImage deathScreen = null;  
        try {
            deathScreen = ImageIO.read(getClass().getResourceAsStream("/r/resources/screens/deathScreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (deathScreen != null) {
            g2.drawImage(deathScreen, 0, 0, jz.screenWidth, jz.screenHeight, null);
        }
        g2.setFont(g2.getFont().deriveFont(50f));
        g2.setColor(pussyPink); 
        g2.drawString("You died.", jz.tileSize * 3, jz.tileSize * 3);
        g2.setFont(g2.getFont().deriveFont(30f));
        g2.drawString("Your blood will stain the ocean floor.", jz.tileSize * 3, jz.tileSize * 3 + 48); 

        g2.drawString("[r] revive", jz.tileSize * 3, jz.tileSize * 5);
        g2.drawString("[esc] succumb", jz.tileSize * 3, jz.tileSize * 5 + 48);
    }

    public void drawDialogueScreen() {
        // WINDOW 
        int x = jz.tileSize; 
        int y = jz.tileSize; 
        int width = jz.screenWidth - (jz.tileSize * 2); 
        int height = jz.tileSize * 7; 

        // SCREEN OVERLAY
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.755f));
        g2.setColor(salkahCyanDarker); // dark teal
        g2.fillRect(0, 0, jz.screenWidth, jz.screenHeight);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));


        g2.setFont(g2.getFont().deriveFont(30f));

        drawSubWindow(x, 300, width, height);

        // ENTITY NAME
        g2.setColor(pussyPink);
        g2.drawString(cEnt.getName(), x + 48, y);

        // DIALOGUE WINDOW 
        drawScrollWindow(x, y + 268, width + (jz.tileSize / 2), height - 75);

        // CHATTER BOX
        drawChatterBox( x, 670, width + (jz.tileSize / 2), 40); 


        // PORTRAIT WINDOW
        drawPortraitWindow(jz.screenWidth / 2 - 256, y - (jz.tileSize), 256, 256);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        g2.setColor(salkahCyanDarker); 
        g2.fillRoundRect(x, y, width, height, 30, 30);
    }

    int scrollOffsetY = 0;

    public void drawScrollWindow(int x, int y, int width, int height) {
        x += 32;
        int contentWidth = width - (jz.tileSize * 2);
        int contentHeight = height - 60;
    
        // Adjust these values based on your needs
        int scrollBarWidth = 10;
        int totalContentHeight = height - 32;
        int visibleContentHeight = contentHeight;
    
        // Calculate the scroll bar height based on the visible content and total content
        int scrollBarHeight = (visibleContentHeight);
        int scrollBarY = y + (scrollOffsetY * contentHeight / totalContentHeight);
    
        // Calculate the maximum  and mimimum scroll offset values based on the content size
        int maxScrollOffsetY = Math.max(0, totalContentHeight - visibleContentHeight);
        scrollOffsetY = Math.max(0, Math.min(scrollOffsetY, maxScrollOffsetY));
    
        // Calculate the visible area of the content
        int visibleAreaX = x;
        int visibleAreaY = y;
        int visibleAreaWidth = contentWidth;
        int visibleAreaHeight = visibleContentHeight;
    
        // Create a clipping area for the visible dialogue window
        Shape previousClip = g2.getClip();
        Rectangle dialogueWindow = new Rectangle(visibleAreaX, visibleAreaY, visibleAreaWidth, visibleAreaHeight);
        g2.setClip(dialogueWindow);
    
        // Draw the visible area of the scrollable content
        g2.setColor(salkahCyanDark);
        g2.fillRoundRect(visibleAreaX, visibleAreaY, visibleAreaWidth, visibleAreaHeight, 15, 15);
    

        synchronized (userInput) {
            userInputString = userInput.toString();
             }
             
        g2.setColor(gillRed);
        
        drawWrappedText(currentDialogue, x + 15, y + 30, visibleAreaWidth - (jz.screenWidth / 2) - 128);

        g2.setColor(pussyPink);
        drawWrappedText(userInputString, x + 15, y + 30, visibleAreaWidth - 655);
    
        // Restore the previous clipping area
        g2.setClip(previousClip);
        
         // Calculate the scrollbar position within the bounds of the dialogue window
    int scrollBarYWithinBounds = Math.min(y + visibleAreaHeight - scrollBarHeight, Math.max(y, scrollBarY));

    // Draw the scrollbar within the bounds of the dialogue window
    
    g2.setColor(pussyPink);
    g2.fillRect(x + contentWidth - scrollBarWidth, scrollBarYWithinBounds, scrollBarWidth, scrollBarHeight);
    }
    
    public void scrollUp() {
        scrollOffsetY -= 10; 
    }

    public void scrollDown() {
        scrollOffsetY += 10; 
    }

    public void drawChatterBox(int x, int y, int width, int height) {
        x += 32; 
        g2.setColor(salkahCyanDark); 
        g2.fillRoundRect(x, y, width - (jz.tileSize * 2), 34, 15, 15);

        // DISPLAY USER INPUT TEXT 
        g2.setColor(pussyPink);
        g2.drawString(userInputString, x + 6, y + 24);

        // KEY BINDINGS UNDERNEATH 
        g2.setFont(g2.getFont().deriveFont(20f));
        g2.setColor(pussyPink); 
        g2.drawString("[c] chatter [space] stay silent [enter] submit [esc] goodbye", jz.screenWidth / 4, y + jz.tileSize); 
    }

    public void drawPortraitWindow(int x, int y, int width, int height) {
        g2.setColor(salkahCyanDarker); 
        g2.fillRoundRect(x, y, width, height + 30, 30, 30); 

        // PUT IN PORTRAIT
        BufferedImage portraitTest = null;  
        try {
            portraitTest = ImageIO.read(getClass().getResourceAsStream(cEnt.getPortraitFilepath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (portraitTest != null) {
            g2.drawImage(portraitTest, x, y, 256, 256, null);
        }
    }

    public void drawEScrollScreen() {
        drawSubWindow(jz.tileSize * 3, jz.tileSize / 2, jz.tileSize * 10, jz.screenHeight - (jz.tileSize));
        drawScrollWindow(jz.tileSize * 3, jz.tileSize, jz.tileSize * 11, jz.screenHeight - (jz.tileSize)); 
    
        ObjectMapper objectMapper = new ObjectMapper();
    
        File jsonFile = new File("/home/estynia/Desktop/javaprojects/Jinczinka/r/resources/bibliothek/poem.json");  // Specify the path to your JSON file
        JsonNode jsonNode = null;
    
        try {
            jsonNode = objectMapper.readTree(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        JsonNode specificValueNode = jsonNode.get("text");
        String specificValue = specificValueNode.asText();
        specificValueNode = jsonNode.get("title"); 
        String titleValue = specificValueNode.asText(); 
    
        g2.setFont(g2.getFont().deriveFont(30f));
        g2.setColor(gillRed); 
    
        // Define the visible area of the scrollable content
        int visibleAreaX = jz.tileSize * 3;
        int visibleAreaY = jz.tileSize;
        int visibleAreaWidth = jz.tileSize * 8 + 32;
        int visibleAreaHeight = jz.screenHeight - jz.tileSize;

        // Calculate the maximum scroll offset values based on the content size
        int maxScrollOffsetY = Math.max(0, jz.tileSize * 11 - jz.screenHeight - (jz.tileSize));
    
        // Limit the scroll offset values within the maximum range
        scrollOffsetY = Math.max(0, Math.min(scrollOffsetY, maxScrollOffsetY));

        g2.drawString(titleValue, visibleAreaX + jz.tileSize * 3, visibleAreaY + (jz.tileSize / 4 - 18));
        
        // Define the clipping area for the scroll window
        Shape previousClip = g2.getClip();
        Rectangle scrollWindow = new Rectangle(visibleAreaX, visibleAreaY, visibleAreaWidth, visibleAreaHeight);
        g2.setClip(scrollWindow);

    
        // Call the drawWrappedText method to draw the wrapped text within the scroll window
          drawWrappedText(specificValue, visibleAreaX + 48, visibleAreaY - 48 + scrollOffsetY * 30, visibleAreaWidth - 350);
        
        // Restore the previous clipping area
        g2.setClip(previousClip);
    }

    public void drawBookScreen(int currentPageIndex) {
        // LEFT SIDE
        drawSubWindow(jz.tileSize / 2, jz.tileSize / 2, jz.tileSize * 15, jz.screenHeight - (jz.tileSize));
        drawDivider((jz.tileSize * 16) / 2 - 8, jz.tileSize / 2, 16, jz.screenHeight - (jz.tileSize));

        int leftPageIndex = currentPageIndex;
        int rightPageIndex = leftPageIndex + 1; 

        drawPageWindow(jz.tileSize - 8, jz.tileSize, jz.tileSize * 7, jz.screenHeight - (jz.tileSize * 2), leftPageIndex);
        drawPageWindow((jz.tileSize * 16) / 2 + 8, jz.tileSize, jz.tileSize * 7, jz.screenHeight - (jz.tileSize * 2), rightPageIndex);
    }

    public void drawPageWindow(int x, int y, int width, int height, int pageIndex) {
        g2.setColor(salkahCyanDark); 
        g2.fillRoundRect(x, y, width, height, 15, 15); 

    }

    public void drawDivider(int x, int y, int width, int height) {
        g2.setColor(pussyPink);
        g2.fillRect(x, y, width, height); 
    }

    public void getBookData() {
        ObjectMapper objectMapper = new ObjectMapper();
    
        File jsonFile = new File("/home/estynia/Desktop/javaprojects/Jinczinka/r/resources/bibliothek/book.json");  // Specify the path to your JSON file
        JsonNode jsonNode = null;
    
        try {
            jsonNode = objectMapper.readTree(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonNode specificValueNode = jsonNode.get("text");
        String specificValue = specificValueNode.asText();
        specificValueNode = jsonNode.get("title"); 
        String titleValue = specificValueNode.asText(); 
    
        g2.setFont(g2.getFont().deriveFont(30f));
        g2.setColor(gillRed); 
    }


    public void drawWrappedText(String text, int x, int y, int maxWidth) {
        FontMetrics fontMetrics = g2.getFontMetrics();
        List<String> lines = getWrappedText(text, fontMetrics, maxWidth);
    
        for (String line : lines) {
            int lineWidth = fontMetrics.stringWidth(line);
            int adjustedX = x; // Adjust x position for center alignment
    
            g2.drawString(line, adjustedX, y - scrollOffsetY * (lines.size()));
            y += fontMetrics.getHeight();
        }
    }
    
    public List<String> getWrappedText(String text, FontMetrics fontMetrics, int maxWidth) {
        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();
    
        String[] words = text.split("\\s+");
    
        for (String word : words) {
            int wordWidth = fontMetrics.stringWidth(word + " ");
    
            if (currentLine.length() + wordWidth <= maxWidth) {
                currentLine.append(word).append(" ");
            } else {
                lines.add(currentLine.toString().trim());
                currentLine = new StringBuilder(word + " ");
            }
        }
    
        lines.add(currentLine.toString().trim());
        return lines;
    }    

}
