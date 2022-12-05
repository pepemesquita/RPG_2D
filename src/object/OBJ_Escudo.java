package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Escudo extends SuperObject{
    public OBJ_Escudo() {
        name = "escudo";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/shield.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
