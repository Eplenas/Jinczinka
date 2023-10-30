package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Pearl_Swindlers extends Entity {
    
    gamePanel jz;
    
    public NPC_Pearl_Swindlers(gamePanel jz) {
        super(jz);
        this.getSprite("/r/resources/sprites/npcs/pearlSwindlersSprite.png");
        this.getName("Only slightly wicked pearl swindler");
   }

   @Override
   public void setAction(int speed) {

   }
}