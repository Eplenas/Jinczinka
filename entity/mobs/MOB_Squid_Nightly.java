package entity.mobs;

import Main.gamePanel;
import entity.Entity;

public class MOB_Squid_Nightly extends Entity {
    
    public MOB_Squid_Nightly(gamePanel jz) {
        super(jz);

        entName = "Emo Squid";
        speed = 1;
        maxHealth = 50;
        health = maxHealth;

        atkDmg = 7;  
        atkDmgRange = 2; 

        this.getSprite("/r/resources/sprites/mobs/squidSpriteNightly.png");
    }
}
