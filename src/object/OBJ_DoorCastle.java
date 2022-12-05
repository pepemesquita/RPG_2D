package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_DoorCastle extends SuperObject{
	
	public OBJ_DoorCastle() {
		name = "doorCastle";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/doorCastle.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		colisao = true;
	}
}