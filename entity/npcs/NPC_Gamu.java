package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Gamu extends Entity {
    
    gamePanel jz; 

    public NPC_Gamu(gamePanel jz) {
        super(jz);
        this.jz = jz; 

        spriteWidth = 192;

    
        entName = "Gamu"; 
        
        this.getSprite("/r/resources/sprites/npcs/gamuSprite.png");
    }

    @Override
    public void setAction(int speed) {

    }
    

}
