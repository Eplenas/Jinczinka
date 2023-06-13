package Main;

import object.*; 
import entity.*;
import entity.mobs.MOB_Peedleback_Shark;
import entity.mobs.MOB_Squid;
import entity.mobs.MOB_Squid_Nightly;
import entity.npcs.NPC_Flan;
import entity.npcs.NPC_Gamu;
import entity.npcs.NPC_Pearl_Swindler;
import entity.npcs.NPC_Pearl_Swindlers;
import entity.npcs.NPC_Salkah;
import entity.npcs.NPC_Saltenne1;
import entity.npcs.NPC_Saltenne2;
import entity.npcs.NPC_Saltenne3;

import java.util.ArrayList;

public class AssetSetter {

    gamePanel jz; 
    Entity cEnt; 

    public AssetSetter(gamePanel jz) {
        this.jz = jz; 


    }

    public void setObject() {
        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(0).worldX = 5 * jz.tileSize;
        jz.obj.get(0).worldY = 7 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(1).worldX = 7 * jz.tileSize;
        jz.obj.get(1).worldY = 5 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(2).worldX = 8 * jz.tileSize;
        jz.obj.get(2).worldY = 4 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(3).worldX = 3 * jz.tileSize;
        jz.obj.get(3).worldY = 5 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(4).worldX = 5 * jz.tileSize;
        jz.obj.get(4).worldY = 4 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(5).worldX = 8 * jz.tileSize;
        jz.obj.get(5).worldY = 3 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(6).worldX = 9 * jz.tileSize;
        jz.obj.get(6).worldY = 3 * jz.tileSize;


        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(7).worldX = 5 * jz.tileSize;
        jz.obj.get(7).worldY = 6 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(8).worldX = 6 * jz.tileSize;
        jz.obj.get(8).worldY = 4 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(9).worldX = 5 * jz.tileSize;
        jz.obj.get(9).worldY = 43 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(10).worldX = 6 * jz.tileSize;
        jz.obj.get(10).worldY = 43 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(11).worldX = 43 * jz.tileSize;
        jz.obj.get(11).worldY = 45 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(12).worldX = 3 * jz.tileSize;
        jz.obj.get(12).worldY = 46 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(13).worldX = 8 * jz.tileSize;
        jz.obj.get(13).worldY = 48 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(14).worldX = 4 * jz.tileSize;
        jz.obj.get(14).worldY = 41 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(15).worldX = 5 * jz.tileSize;
        jz.obj.get(15).worldY = 22 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(16).worldX = 7 * jz.tileSize;
        jz.obj.get(16).worldY = 21 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(17).worldX = 3 * jz.tileSize;
        jz.obj.get(17).worldY = 23 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(18).worldX = 3 * jz.tileSize;
        jz.obj.get(18).worldY = 24 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(19).worldX = 5 * jz.tileSize;
        jz.obj.get(19).worldY = 24 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(20).worldX = 8 * jz.tileSize;
        jz.obj.get(20).worldY = 27 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(21).worldX = 9 * jz.tileSize;
        jz.obj.get(21).worldY = 25 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(22).worldX = 9 * jz.tileSize;
        jz.obj.get(22).worldY = 29 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(23).worldX = 23 * jz.tileSize;
        jz.obj.get(23).worldY = 30 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(24).worldX = 24 * jz.tileSize;
        jz.obj.get(24).worldY = 31 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(25).worldX = 23 * jz.tileSize;
        jz.obj.get(25).worldY = 28 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(26).worldX = 27 * jz.tileSize;
        jz.obj.get(26).worldY = 26 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(27).worldX = 24 * jz.tileSize;
        jz.obj.get(27).worldY = 31 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(28).worldX = 26 * jz.tileSize;
        jz.obj.get(28).worldY = 32 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(29).worldX = 25 * jz.tileSize;
        jz.obj.get(29).worldY = 31 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(30).worldX = 24 * jz.tileSize;
        jz.obj.get(30).worldY = 27 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(31).worldX = 22 * jz.tileSize;
        jz.obj.get(31).worldY = 32 * jz.tileSize;


        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(32).worldX = 22 * jz.tileSize;
        jz.obj.get(32).worldY = 33 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(33).worldX = 24 * jz.tileSize;
        jz.obj.get(33).worldY = 28 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(34).worldX = 25 * jz.tileSize;
        jz.obj.get(34).worldY = 27 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(35).worldX = 25 * jz.tileSize;
        jz.obj.get(35).worldY = 28 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(36).worldX = 23 * jz.tileSize;
        jz.obj.get(36).worldY = 31 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(37).worldX = 20 * jz.tileSize;
        jz.obj.get(37).worldY = 25 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(38).worldX = 22 * jz.tileSize;
        jz.obj.get(38).worldY = 24 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(39).worldX = 20 * jz.tileSize;
        jz.obj.get(39).worldY = 26 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(40).worldX = 21 * jz.tileSize;
        jz.obj.get(40).worldY = 24 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(41).worldX = 22 * jz.tileSize;
        jz.obj.get(41).worldY = 25 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(42).worldX = 25 * jz.tileSize;
        jz.obj.get(42).worldY = 18 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(43).worldX = 26 * jz.tileSize;
        jz.obj.get(43).worldY = 23 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(44).worldX = 24 * jz.tileSize;
        jz.obj.get(44).worldY = 22 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(45).worldX = 24 * jz.tileSize;
        jz.obj.get(45).worldY = 19 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(46).worldX = 17 * jz.tileSize;
        jz.obj.get(46).worldY = 25 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(47).worldX = 43 * jz.tileSize;
        jz.obj.get(47).worldY = 20 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(48).worldX = 44 * jz.tileSize;
        jz.obj.get(48).worldY = 32 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(49).worldX = 43 * jz.tileSize;
        jz.obj.get(49).worldY = 21 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(50).worldX = 48 * jz.tileSize;
        jz.obj.get(50).worldY = 30 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(51).worldX = 47 * jz.tileSize;
        jz.obj.get(51).worldY = 25 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(52).worldX = 48 * jz.tileSize;
        jz.obj.get(52).worldY = 23 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(53).worldX = 42 * jz.tileSize;
        jz.obj.get(53).worldY = 18 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(54).worldX = 6 * jz.tileSize;
        jz.obj.get(54).worldY = 40 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(55).worldX = 5 * jz.tileSize;
        jz.obj.get(55).worldY = 38 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(56).worldX = 4 * jz.tileSize;
        jz.obj.get(56).worldY = 42 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(57).worldX = 4 * jz.tileSize;
        jz.obj.get(57).worldY = 34 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp2());
        jz.obj.get(58).worldX = 5 * jz.tileSize;
        jz.obj.get(58).worldY = 36 * jz.tileSize;
    
        jz.obj.add(new OBJ_Kelp3());
        jz.obj.get(59).worldX = 7 * jz.tileSize;
        jz.obj.get(59).worldY = 29 * jz.tileSize;

        jz.obj.add(new OBJ_Kelp1());
        jz.obj.get(60).worldX = 8 * jz.tileSize;
        jz.obj.get(60).worldY = 37 * jz.tileSize;

        jz.obj.add(new OBJ_Shell1());
        jz.obj.get(61).worldX = 44 * jz.tileSize;
        jz.obj.get(61).worldY = 28 * jz.tileSize;
    
        jz.obj.add(new OBJ_Shell1());
        jz.obj.get(62).worldX = 42 * jz.tileSize;
        jz.obj.get(62).worldY = 26 * jz.tileSize;

        jz.obj.add(new OBJ_Shell2());
        jz.obj.get(63).worldX = 40 * jz.tileSize;
        jz.obj.get(63).worldY = 25 * jz.tileSize;

        
        jz.obj.add(new OBJ_Whale_Corpse());
        jz.obj.get(64).worldX = 10 * jz.tileSize;
        jz.obj.get(64).worldY = 23 * jz.tileSize;
    }
    

    public void setNPC() {
        jz.npcs.add(new NPC_Salkah(jz));
        jz.npcs.get(0).worldX = 34 * jz.tileSize;
        jz.npcs.get(0).worldY = 2 * jz.tileSize;
    
        jz.npcs.add(new NPC_Saltenne1(jz));
        jz.npcs.get(1).worldX = 28 * jz.tileSize;
        jz.npcs.get(1).worldY = 2 * jz.tileSize;
    
        jz.npcs.add(new NPC_Flan(jz));
        jz.npcs.get(2).worldX = 8 * jz.tileSize;
        jz.npcs.get(2).worldY = 42 * jz.tileSize;
    
        jz.npcs.add(new NPC_Saltenne2(jz));
        jz.npcs.get(3).worldX = 24 * jz.tileSize;
        jz.npcs.get(3).worldY = 3 * jz.tileSize;
    
        jz.npcs.add(new NPC_Saltenne3(jz));
        jz.npcs.get(4).worldX = 25 * jz.tileSize;
        jz.npcs.get(4).worldY = 2 * jz.tileSize;

        jz.npcs.add(new NPC_Gamu(jz)); 
        jz.npcs.get(5).worldX = 34 * jz.tileSize;
        jz.npcs.get(5).worldY = 4 * jz.tileSize;

        jz.npcs.add(new NPC_Saltenne2(jz));
        jz.npcs.get(6).worldX = 28 * jz.tileSize;
        jz.npcs.get(6).worldY = 3 * jz.tileSize;

        jz.npcs.add(new NPC_Saltenne1(jz));
        jz.npcs.get(7).worldX = 24 * jz.tileSize;
        jz.npcs.get(7).worldY = 5 * jz.tileSize;

        jz.npcs.add(new NPC_Saltenne1(jz));
        jz.npcs.get(8).worldX = 21 * jz.tileSize;
        jz.npcs.get(8).worldY = 3 * jz.tileSize;

        jz.npcs.add(new NPC_Pearl_Swindlers(jz));
        jz.npcs.get(9).worldX = 45 * jz.tileSize; 
        jz.npcs.get(9).worldY = 30 * jz.tileSize; 

        jz.npcs.add(new NPC_Pearl_Swindlers(jz));
        jz.npcs.get(10).worldX = 43 * jz.tileSize; 
        jz.npcs.get(10).worldY = 28 * jz.tileSize; 

        jz.npcs.add(new NPC_Pearl_Swindlers(jz));
        jz.npcs.get(11).worldX = 48 * jz.tileSize; 
        jz.npcs.get(11).worldY = 26 * jz.tileSize; 

        jz.npcs.add(new NPC_Pearl_Swindler(jz));
        jz.npcs.get(12).worldX = 43 * jz.tileSize; 
        jz.npcs.get(12).worldY = 23 * jz.tileSize; 

        jz.npcs.add(new NPC_Pearl_Swindler(jz));
        jz.npcs.get(13).worldX = 47 * jz.tileSize; 
        jz.npcs.get(13).worldY = 25 * jz.tileSize; 

    }
    

    public void setMob() {
        jz.mobs.add(new MOB_Squid(jz));
        jz.mobs.get(0).worldX = 10 * jz.tileSize;
        jz.mobs.get(0).worldY = 23 * jz.tileSize;

        jz.mobs.add(new MOB_Squid(jz));
        jz.mobs.get(1).worldX = 12 * jz.tileSize;
        jz.mobs.get(1).worldY = 27 * jz.tileSize;

        jz.mobs.add(new MOB_Squid(jz));
        jz.mobs.get(2).worldX = 15 * jz.tileSize;
        jz.mobs.get(2).worldY = 29 * jz.tileSize;

        jz.mobs.add(new MOB_Squid(jz));
        jz.mobs.get(3).worldX = 8 * jz.tileSize;
        jz.mobs.get(3).worldY = 21 * jz.tileSize;

        jz.mobs.add(new MOB_Squid_Nightly(jz));
        jz.mobs.get(4).worldX = 15 * jz.tileSize;
        jz.mobs.get(4).worldY = 24 * jz.tileSize;

        jz.mobs.add(new MOB_Squid_Nightly(jz));
        jz.mobs.get(5).worldX = 18 * jz.tileSize;
        jz.mobs.get(5).worldY = 27 * jz.tileSize;

        jz.mobs.add(new MOB_Peedleback_Shark(jz));
        jz.mobs.get(6).worldX = 25 * jz.tileSize;
        jz.mobs.get(6).worldY = 25 * jz.tileSize;

        jz.mobs.add(new MOB_Peedleback_Shark(jz));
        jz.mobs.get(7).worldX = 8 * jz.tileSize;
        jz.mobs.get(7).worldY = 15 * jz.tileSize;
    
    }
    
}
