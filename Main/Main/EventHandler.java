package Main;

import java.awt.Rectangle;

import javax.swing.Timer;

public class EventHandler {
    gamePanel jz; 
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    UI jzUI; 

    public EventHandler(gamePanel jz) {
        this.jz = jz; 

        eventRect = new Rectangle(); 
        eventRect.x = 23;
        eventRect.y = 7;
        eventRect.width = 64;
        eventRect.height = 64; 
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

    }

    public void checkEvent() {
        if (hit(27, 16) == true) {
            // event happens
            damagePit();
        }
    }

    public boolean hit(int eventCol, int eventRow) {
        boolean hit = false;

        if (jz.player.hitbox.intersects(eventRect)) {
            hit = true;  
        }

        return hit; 
    }

    public void damagePit() {
        // jz.player.health -= 50;
        jz.jzUI.showMessage("You fall into a pit!");
        System.out.println("You fall into a pit!");
    }

    public void healingGrotto() {
        jz.jzUI.showMessage("You can recover from your wounds here.");
        Timer healthRecoveryTimer = null;
        if (healthRecoveryTimer == null || !healthRecoveryTimer.isRunning()) {
            healthRecoveryTimer = new Timer(1000, e -> {
                if (jz.player.maxHealth > jz.player.health) {
                    jz.player.health++;
                }
            });
            healthRecoveryTimer.setInitialDelay(0);
            healthRecoveryTimer.start();
        }
    }
    public void whirlpoolTeleport() {
        jz.jzUI.showMessage("You get sucked into a whirlpool.");
        jz.player.worldX = jz.tileSize * 37;
        jz.player.worldX = jz.tileSize * 48; 
    }
}
