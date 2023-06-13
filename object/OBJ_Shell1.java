package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Shell1 extends SuperObject {
    
    public OBJ_Shell1() {
        name = "shell"; 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/r/resources/objects/shell1.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
