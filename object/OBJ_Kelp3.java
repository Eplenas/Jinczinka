package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Kelp3 extends OBJ_Kelp1 {
    
    public OBJ_Kelp3() {
        super(); 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/r/resources/objects/kelp3.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
