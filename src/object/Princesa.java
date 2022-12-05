package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Princesa extends SuperObject{
    public Princesa() {
    	name = "princesa";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/princess_left.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        colisao = true;
    }
}

