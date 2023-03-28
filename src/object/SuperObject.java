package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {

	
	
	
	public BufferedImage image;
	public String name;
	public boolean collision= false;
	public int worldX,worldY;
	public Rectangle solidalan= new Rectangle(0,0,48,48);
	public int solidAreaDefaultX=0;
	public int solidAreaDefaultY=0;
	
	public void draw (Graphics2D g2,GamePanel gp) {
		
		int screenX = worldX-gp.girl.worldX + gp.girl.screenX;
		int screenY = worldY-gp.girl.worldY + gp.girl.screenY;
		
		if (worldX + gp.tileSize> gp.girl.worldX-gp.girl.screenX 
		&& worldX -gp.tileSize < gp.girl.worldX+ gp.girl.screenX 
		&& worldY +gp.tileSize > gp.girl.worldY-gp.girl.screenY 
		&& worldY -gp.tileSize < gp.girl.worldY+ gp.girl.screenY) {
			
		g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
		}
		
	}
	
	
	
	
	
	
	
	
}
