package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Whale_Corpse extends SuperObject {
    
    public OBJ_Whale_Corpse() {
        width = 666;
        height = 250; 
        name = "Whale corpse"; 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/r/resources/objects/whaleCorpse.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
