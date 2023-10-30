/* ackage Main; 

import entity.*;

public class CollisionChecker { 

    public gamePanel jz; 
    public int tileNum1, tileNum2; 
    Entity ent; 

    public CollisionChecker(gamePanel jz) {
        this.jz = jz; 
    }

 public void collisionUpdate(int tileNum1, int tileNum2) {
       if (jz.tileM != null && (jz.tileM.tile[tileNum1].collision == true || jz.tileM.tile[tileNum2].collision == true)) {
            
        }
    }

    public void checkTile(Entity ent) {
        int entLeftWorldX = ent.worldX + ent.solidArea.x; 
        int entRightWorldX = ent.worldX + ent.solidArea.x + ent.solidArea.width; 
        int entTopWorldY = ent.worldY + ent.solidArea.y; 
        int entBottomWorldY = ent.worldY + ent.solidArea.y  + ent.solidArea.height; 

        int entLeftCol = entLeftWorldX / jz.tileSize; 
        int entRightCol = entRightWorldX / jz.tileSize; 
        int entTopRow = entTopWorldY / jz.tileSize; 
        int entBottomRow = entBottomWorldY / jz.tileSize; 
    

        switch(ent.direction) {
            case "up":
                entTopRow = (entTopWorldY - ent.speed) / jz.tileSize;
                tileNum1 = jz.tileM.mapTileNum[entLeftCol] [entTopRow];
                tileNum2 = jz.tileM.mapTileNum[entRightCol] [entTopRow];
                collisionUpdate(tileNum1, tileNum2); 
            break; 
            case "down": 
                entBottomRow = (entBottomWorldY + ent.speed) / jz.tileSize;
                tileNum1 = jz.tileM.mapTileNum[entLeftCol] [entBottomRow];
                tileNum2 = jz.tileM.mapTileNum[entRightCol] [entBottomRow];
                collisionUpdate( tileNum1, tileNum2);
            break; 
            // resume here 
            case "left":
                entLeftCol = (entLeftWorldX + ent.speed) / jz.tileSize;
                tileNum1 = jz.tileM.mapTileNum[entLeftCol] [entTopRow];
                tileNum2 = jz.tileM.mapTileNum[entLeftCol] [entBottomRow];
                collisionUpdate(tileNum1, tileNum2);
            break; 
            case "right":
                entRightCol = (entRightWorldX + ent.speed) / jz.tileSize;
                tileNum1 = jz.tileM.mapTileNum[entLeftCol] [entTopRow];
                tileNum2 = jz.tileM.mapTileNum[entRightCol] [entBottomRow];
                collisionUpdate(tileNum1, tileNum2);
            break; 
        } 

        // NON-PLAYER ENTITIES
        public void checkEntity(Entity entity, Entity[] target) {

            int index = 999; 

            for (int i = 0; i < target.length; i++) {

                if(target[i] != null) {

            entity.hitBox.x = entity.worldX + entity.hitBox.y; 
            entity.hitBox.y = entity.worldY + entity.hitBox.y;

            target[i].hitBox.x = target[i].worldX + target[i].hitBox.x;
            target[i].hitBox.y = target[i].worldY + target[i].hitBox.y;

            switch(entity.direction) {
                case: "up":
                    entity.hitBox.y -= entity.speed;
                    if (entity.hitBox.intersects(target[i].hitBox)) {
                        if (target[i].collision == true)
                    }
                    if (player == true) {
                        index = i; 
                    }
            }
        }
        }
    }
}  */



