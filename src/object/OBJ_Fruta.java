package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Fruta extends SuperObject{
	
	public OBJ_Fruta() {
		name = "fruta";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/apple.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}