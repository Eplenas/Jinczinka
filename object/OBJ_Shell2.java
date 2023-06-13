package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Shell2 extends SuperObject {
    
    public OBJ_Shell2() {
        name = "shell"; 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/r/resources/objects/shell2.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
