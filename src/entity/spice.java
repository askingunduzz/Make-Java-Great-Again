package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class spice {

	
	public int worldX, worldY ;
	public int speed;
	
	public BufferedImage arka , on , sol , sag ;
	public String direction;
	
	public int spriteCounter = 0;
	 public int spriteNum = 1;
	 public Rectangle solidArea;
	 public int solidAreaDefaultX, solidAreaDefaultY;
	 public boolean collisionOn = false;
}
