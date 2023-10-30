package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Gamu extends Entity {
    
    gamePanel jz; 

    public NPC_Gamu(gamePanel jz) {
        super(jz);

        spriteWidth = 192;
        this.getSprite("/r/resources/sprites/npcs/gamuSprite.png");
        this.getName("Gamu");
    }


    @Override
    public void setAction(int speed) {

    }
    

}
