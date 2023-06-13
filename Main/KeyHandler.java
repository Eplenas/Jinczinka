package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.awt.Toolkit;



public class KeyHandler extends JPanel {
    public boolean upPress, downPress, leftPress, rightPress, mutePress, controlPress;

    gamePanel jz; 
    UI jzUI;

    // DEBUG
    public boolean checkDrawTime = false; 

    public boolean acceptUserInput = false; 
    public boolean printUserInput = false; 
    public boolean chatterPress = false; 
    // public boolean capsLockOn;

    public KeyHandler(gamePanel jz) {
        this.jz = jz; 

        mapKey(KeyEvent.VK_W, "up");
        mapKey(KeyEvent.VK_A, "left");
        mapKey(KeyEvent.VK_S, "down");
        mapKey(KeyEvent.VK_D, "right");
        mapKey(KeyEvent.VK_UP, "upArrow");
        mapKey(KeyEvent.VK_DOWN, "downArrow");
        mapKey(KeyEvent.VK_M, "mute");
        mapKey(KeyEvent.VK_ESCAPE, "exit");
        mapKey(KeyEvent.VK_T, "debug");
        mapKey(KeyEvent.VK_ENTER, "enter");
        mapKey(KeyEvent.VK_CAPS_LOCK, "capsLock");  
        mapKey(KeyEvent.VK_C, "chatter"); 
        mapKey(KeyEvent.VK_B, "booktest");
        mapKey(KeyEvent.VK_R, "sprint");
        mapKey(KeyEvent.VK_SPACE, "space");
        mapKey(KeyEvent.VK_CONTROL, "control"); 

        }

        public void mapKey(int keyCode, String actionName) {
            InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = this.getActionMap();
        
            inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), actionName);
            inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, true), actionName + "-released"); // Add key release binding
            actionMap.put(actionName, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  handleAction(actionName); 
                }
        });

            actionMap.put(actionName + "-released", new AbstractAction() { // Add key release action
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (actionName) {
                        case "up":
                            upPress = false;
                            break;
                        case "down":
                            downPress = false;
                            break;
                        case "left":
                            leftPress = false;
                            break;
                        case "right":
                            rightPress = false;
                            break;
                        case "mute":
                            mutePress = false;
                            break;
                        case "capsLock":

                        break;
                    }
                }
            });
        }        

          // Intiates different keybindings for the appropriate play state
          public void handleAction(String actionName) {
            if (jz.gameState == (jz.dialogueState)) {
                handleDialogueStateActions(actionName);
            }
            else if (jz.gameState == (jz.pauseState)) {
                handlePauseStateActions(actionName);
            } 
            else if (jz.gameState == (jz.titleState)) {
                handleTitleStateActions(actionName);
            }
             else if (jz.gameState == (jz.playState)) {
                handlePlayStateActions(actionName); 
            }
            else if (jz.gameState == (jz.deathState)) {
                handleDeathStateActions(actionName); 
            }
        }

        private void handleTitleStateActions(String actionName) {
            switch(actionName) {
                case "enter": 
                    jz.gameState = jz.playState;
                break;
                case "exit": 
                    System.exit(0); 
                break; 
            }
        }

        private void handlePlayStateActions(String actionName) {
            switch (actionName) {
                case "up":
                    upPress = true;
                    break;
                case "down":
                    downPress = true;
                    break;
                case "left":
                    leftPress = true;
                    break;
                case "right":
                    rightPress = true;
                    break;
                case "mute":
                    mutePress = true;
                    break;
                case "exit":
                    jz.gameState = jz.pauseState;
                    break;
                case "debug":
                    checkDrawTime = !checkDrawTime;
                    break;
                case "up-released":
                    upPress = false;
                    break;
                case "down-released":
                    downPress = false;
                    break;
                case "left-released":
                    leftPress = false;
                    break;
                case "right-released":
                    rightPress = false;
                    break;
                case "mute-released":
                    mutePress = false;
                    break;
                case "sprint": 
                    Timer staminaTimer = null;
                
                        jz.player.speed = 4;
                        if (staminaTimer == null || !staminaTimer.isRunning()) {
                            staminaTimer = new Timer(1000, e -> {
                                if (0 < jz.player.stamina && jz.player.playerIsStill == false) {
                                    jz.player.stamina--;
                                }
                                if (jz.player.stamina == 0) {
                                    jz.player.speed = 2;
                                }
                                if (jz.player.stamina != jz.player.maxStamina && jz.player.playerIsStill) {
                                    jz.player.stamina++; 
                                }
                            });
                            staminaTimer.setInitialDelay(0);
                            staminaTimer.start();
                        }
                    break;
                case "sprint-released":
                    jz.player.speed = 2;
                    break;
                case "chatter":
                    chatterPress = true;
                    controlPress = !controlPress;  
                    break;
                case "booktest":
                    jz.gameState = jz.bookState; 
                    break;
                case "control":
                    controlPress = true; 
                    break; 
            }
        }

        private void handlePauseStateActions(String actionName) {
            switch (actionName) {
                case "space": 
                    jz.gameState = jz.playState; 
                    break;
                case "exit": 
                    System.exit(0); 
                    break; 
            }
        }

        private void handleDialogueStateActions(String actionName) {
            switch (actionName) {
                case "exit": 
                    jz.gameState = jz.playState; 
                    chatterPress = false; 
                    break;
                case "chatter":
                    acceptUserInput = true; 
                    break; 
                case "upArrow":
                    jz.jzUI.scrollUp();
                break;
                case "downArrow":
                    jz.jzUI.scrollDown(); 
                break; 
                case "enter":
                     if (jz.jzUI.userInput != null) {
                            jz.jzUI.userInput.setLength(0); 
                            jz.jzUI.userInputString = "";
                    } else {
                       
                        System.out.println("jz.jzUI.userInput is null");
                    }
                    break;     
                case "enter-released":
                    break;
            }
        }

        private void handleDeathStateActions(String actionName) {
            switch (actionName) {
                case "exit": 
                    System.exit(0); 
                    break;
                case "sprint": 
                    jz.gameState = jz.playState;
                    jz.player.isInvincible = false; 
                    jz.player.setDefaultValues(); 
                    jz.jzUI.showMessage("By Ansel's grace, you have been revived.");
                    break;


            }
        }

    }