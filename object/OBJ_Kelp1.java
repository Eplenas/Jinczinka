package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Kelp1 extends SuperObject {
    
    public OBJ_Kelp1() {
        name = "kelp"; 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/r/resources/objects/kelp1.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
