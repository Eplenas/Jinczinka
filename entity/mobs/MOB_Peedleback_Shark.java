package entity.mobs;

import Main.gamePanel;
import entity.Entity;

public class MOB_Peedleback_Shark extends Entity {
    
    public MOB_Peedleback_Shark(gamePanel jz) {
        super(jz);

        entName = "Peedleback Shark";
        speed = 1;
        maxHealth = 215;
        health = maxHealth;

        spriteWidth = 156; 

        atkDmg = 30;  
        atkDmgRange = 7; 

        this.getSprite("/r/resources/sprites/mobs/peedlebackSharkSprite.png");
    }
}
