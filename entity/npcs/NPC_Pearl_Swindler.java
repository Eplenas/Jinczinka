package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Pearl_Swindler extends Entity {
    
    gamePanel jz;
    
    public NPC_Pearl_Swindler(gamePanel jz) {
        super(jz);
        this.getSprite("/r/resources/sprites/npcs/pearlSwindlerSprite.png");
        this.getName("WRETCHED Pearl Swindler");
   }

   @Override
   public void setAction(int speed) {

   }
}