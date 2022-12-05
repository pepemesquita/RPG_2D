package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Moedas extends SuperObject{
    public OBJ_Moedas() {
        name = "moedas";
        value = 600;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coin.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
