package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

import Main.Animation; 

public class NPC_Flan extends Entity {
    
    gamePanel jz;
    public Animation animation;
    
    public NPC_Flan(gamePanel jz) {
        super(jz); 
                spriteSheetPath = "r/resources/sprites/npcs/flanSpriteSheet.png";
       //  animation = Animation.createAnimation("r/resources/sprites/npcs/flanSpriteSheet.png", 32, 48);
        this.portraitFilepath = "/r/resources/portraits/placeholderPortrait.png"; 
        // this.getSprite("/r/resources/sprites/npcs/flanSprite.gif");
        spriteHeight = 96; 
        this.getSprite("/r/resources/sprites/npcs/flanSprite.png");
        this.getName("Flan (. . . eurlyse");

     }


   public void setDialogue() {
       dialogues[0] = "cumcucmcumcumcucummod tempor incididunt ut labore et dolore magna aliqua. Morbi tristique senectus et netus et. Fringilla urna porttitor rhoncus dolor purus non enim praesent. Magna sit amet purus gravida quis blandit. Amet massa vitae tortor condimentum lacinia quis vel eros. Sem fringilla ut morbi tincidunt augue interdum velit euismod. Amet tellus cras adipiscing enim. A diam maecenas sed enim ut sem viverra. Sit amet commodo nulla facilisi nullam vehicula ipsum a arcu. Ac turpis egestas maecenas pharetra convallis posuere morbi leo. Rutrum quisque non tellus orci ac auctor. Consequat id porta nibh venenatis cras sed. Sit amet mattis vulputate enim nulla. Est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus. Cursus risus at ultrices mi tempus imperdiet nulla. Iaculis eu non diam phasellus vestibulum lorem. Duis convallis convallis tellus id interdum velit laoreet. Eu sem integer vitae justo eget magna. Feugiat in fermentum posuere urna nec tincidunt praesent. Sit amet cursus sit amet dictum sit amet. Vitae proin sagittis nisl rhoncus mattis.  Non sodales neque sodales ut. Donec ultrices tincidunt arcu non sodales neque sodales ut. At ultrices mi tempus imperdiet nulla malesuada. Auctor urna nunc id cursus metus aliquam eleifend mi in. Purus gravida quis blandit turpis cursus in hac. Id diam maecenas ultricies mi. Pellentesque id nibh tortor id aliquet lectus proin. Pellentesque adipiscing commodo elit at imperdiet dui accumsan sit. Sit amet nisl suscipit adipiscing. Suspendisse ultrices gravida dictum fusce ut placerat orci.  Suspendisse faucibus interdum posuere lorem ipsum dolor sit amet. Tempus urna et pharetra pharetra massa massa ultricies mi. Neque aliquam vestibulum morbi blandit cursus risus at. Quam viverra orci sagittis eu. Neque volutpat ac tincidunt vitae semper quis. Pretium aenean pharetra magna ac. Pellentesque sit amet porttitor eget dolor morbi non arcu. Velit laoreet id donec ultrices tincidunt arcu. Id porta nibh venenatis cras sed. Arcu dictum varius duis at consectetur. Nec ultrices dui sapien eget mi proin sed libero. Posuere morbi leo urna molestie at elementum. Quam id leo in vitae. Sollicitudin tempor id eu nisl nunc. In nisl nisi scelerisque eu. A condimentum vitae sapien pellentesque. Nec nam aliquam sem et tortor consequat id porta. Eu consequat ac felis donec et odio. Placerat in egestas erat imperdiet sed euismod. Scelerisque fermentum dui faucibus in ornare quam viverra. Felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices. Eget sit amet tellus cras adipiscing enim eu. Adipiscing bibendum est ultricies integer quis auctor. Dignissim sodales ut eu sem integer vitae. Orci porta non pulvinar neque laoreet suspendisse interdum consectetur libero. Venenatis tellus in metus vulputate eu scelerisque felis imperdiet. Sit amet nisl suscipit adipiscing bibendum est ultricies integer. Volutpat commodo sed egestas egestas. At tellus at urna condimentum mattis. Mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus. Enim eu turpis egestas pretium aenean pharetra magna ac. A condimentum vitae sapien pellentesque habitant morbi. Libero id faucibus nisl tincidunt eget. Quisque sagittis purus sit amet volutpat consequat mauris nunc congue. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Elit sed vulputate mi sit. Id consectetur purus ut faucibus pulvinar elementum integer enim neque. Enim sit amet venenatis urna cursus. Aliquam ut porttitor leo a diam sollicitudin tempor id.";
       dialogues[1] = "dshkshfks";
       dialogues[2] = "ijafijfe";
       dialogues[3] = "ksdaifhifehe";
   }

    @Override
    public void setAction(int speed) {

    } 
}
