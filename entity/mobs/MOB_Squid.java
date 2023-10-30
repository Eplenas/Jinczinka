package entity.mobs;

import entity.Entity;
import Main.gamePanel;

public class MOB_Squid extends Entity {
    
    public MOB_Squid(gamePanel jz) {
        super(jz);

        entName = "Squid";
        speed = 1;
        maxHealth = 50;
        health = maxHealth;

        atkDmg = 8;
        atkDmgRange = 3;   

        this.getSprite("/r/resources/sprites/mobs/squidSprite.png");
    }
}
