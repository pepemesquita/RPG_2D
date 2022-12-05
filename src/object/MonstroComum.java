package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class MonstroComum extends OBJ_monstro{
    public MonstroComum() {
        dano = 3;
        vidaMonstro = 10;
        try {
			image = ImageIO.read(getClass().getResourceAsStream("/monster/orc_right_2.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    }
}
