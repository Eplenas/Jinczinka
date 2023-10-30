package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Saltenne2 extends Entity {
    
    gamePanel jz; 

    public NPC_Saltenne2(gamePanel jz) {
        super(jz); 
        this.jz = jz; 
        speed = 2; 

        this.getSprite("/r/resources/sprites/npcs/saltenneSprite2.png");
        this.getName("Saltenn");

    }
}