package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NPC extends SuperObject{
    public NPC() {
    	name = "NPC";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/npc.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        colisao = true;
    }
}