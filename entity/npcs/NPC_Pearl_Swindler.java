package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Pearl_Swindler extends Entity {
    
    gamePanel jz;
    
    public NPC_Pearl_Swindler(gamePanel jz) {
        super(jz);
        this.jz = jz; 
        
        entName = "WRETCHED Pearl Swindler";

        this.getSprite("/r/resources/sprites/npcs/pearlSwindlerSprite.png");


   }

   @Override
   public void setAction(int speed) {

   }
}