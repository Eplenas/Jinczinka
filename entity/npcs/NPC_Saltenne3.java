package entity.npcs;

import Main.gamePanel;
import entity.Entity;

public class NPC_Saltenne3 extends Entity {
    
    gamePanel jz; 

    public NPC_Saltenne3(gamePanel jz) {
        super(jz);
        this.jz = jz;  
        speed = 1; 

        entName = "Saltenn";

        this.getSprite("/r/resources/sprites/npcs/saltenneSprite3.png");
    }

    public String getPortraitFilepath() {
        return this.portraitFilepath; 
    }

    public String getName() {
        return this.entName; 
    }
}