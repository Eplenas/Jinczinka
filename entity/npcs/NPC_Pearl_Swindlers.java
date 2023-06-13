package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Pearl_Swindlers extends Entity {
    
    gamePanel jz;
    
    public NPC_Pearl_Swindlers(gamePanel jz) {
        super(jz);
        this.jz = jz; 
        
        entName = "Wicked Pearl Swindlers";

        this.getSprite("/r/resources/sprites/npcs/pearlSwindlersSprite.png");


   }

   @Override
   public void setAction(int speed) {

   }
}