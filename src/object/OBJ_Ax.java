package object;

import java.io.IOException;
import javax.imageio.ImageIO;
public class OBJ_Ax extends SuperObject {

public OBJ_Ax(){
	name="Ax";
	try {
		image=ImageIO.read(getClass().getResourceAsStream("/objects/ax.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	
	
}
