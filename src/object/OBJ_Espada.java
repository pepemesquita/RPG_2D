package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Espada extends SuperObject{
    public OBJ_Espada() {
        name = "espada";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/sword.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
