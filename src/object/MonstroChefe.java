package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class MonstroChefe extends OBJ_monstro{
    public MonstroChefe() {
        dano = 5;
        vidaMonstro = 15;
        try {
			image = ImageIO.read(getClass().getResourceAsStream("/monster/monsterBoss.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    }
}
