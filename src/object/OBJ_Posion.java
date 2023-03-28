package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Posion extends SuperObject {

	public OBJ_Posion() {


	name="Posion";
	try {
		image=ImageIO.read(getClass().getResourceAsStream("/objects/mmm.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	}
	

