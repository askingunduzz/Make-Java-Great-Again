package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import main.GamePanel;
import main.KeyHandler;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class girl extends spice{

	GamePanel gamepanel;
	
	KeyHandler keyH;
	
   public final int screenX;
   public final int screenY; 
   int hasAx= 0 ;
	
	public girl (GamePanel gamepanel , KeyHandler keyH) {
		this.gamepanel = gamepanel;
		this.keyH = keyH;
		
		screenX = gamepanel.screenWidth /2 - (gamepanel.tileSize/2);
		screenY = gamepanel.screenHeight /2 - (gamepanel.tileSize/2);
		
		solidArea= new Rectangle();
		solidArea.x= 8;
		solidArea.y= 16;
		solidAreaDefaultX= solidArea.x;
		solidAreaDefaultY= solidArea.y;
		solidArea.width=32;
		solidArea.height=32;
		 
		setDefaultValues();
		getGirlImage();
	}	
	
	public void setDefaultValues() {
		
		worldX=gamepanel.tileSize*23;
				
		worldY = gamepanel.tileSize*23;
		
		speed=4;
		direction="down";
	}
	
	public void getGirlImage() {
		try {
			arka = ImageIO.read(getClass().getResourceAsStream("/player/arka.png"));
			sol = ImageIO.read(getClass().getResourceAsStream("/player/sol.png"));
			on = ImageIO.read(getClass().getResourceAsStream("/player/on.png"));
			sag = ImageIO.read(getClass().getResourceAsStream("/player/sag.png"));
			
			
			
			}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void guncelleme() {
		
		if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
		
		
		if ( keyH.upPressed== true) {
			direction="up";
			
			
		}
		else if (keyH.downPressed== true) {
			direction="down";
		
		}
		else if (keyH.leftPressed== true) {
			direction="left";
			
		}
		else if (keyH.rightPressed== true) {
			direction="right";
			
		}
		 
		//CHECK TILE COLLISION
		collisionOn=false;
		gamepanel.cChecker.checkTile(this);
		
		// Check object collesion 
		int objIndex=  gamepanel.cChecker.checkfortheObject(this,true);
		pickUpObject(objIndex);
		
		// ıf collision is false, player can move
		
		if (collisionOn==false) {
			
			switch(direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX += speed;
				break;
			}
			
		}
		
		
		spriteCounter++;
		
		if (spriteCounter>12) {
			if (spriteNum==1) {
				spriteNum=2;
			}
			else if (spriteNum==2) {
				spriteNum=1;
		}
		spriteCounter=0;
	}
}
	}
	
	
	public void pickUpObject ( int i) {
		
		if (i != 999) {
			String objectName= gamepanel.obj[i].name;
			//gp.obj[i] = null;
			switch (objectName) {
			case "Ax":
				hasAx++;
				gamepanel.obj[i] =null;
				break;
			case "Door":
			// if aç !! 
				//İFI DOOR AÇIP YENİ BİR OYUN AÇMAK ADINA AÇIYORUUUUUZZ
				// BURAYA EKLE
				if (hasAx>0) {
					gamepanel.obj[i] =null;
					hasAx--;
				}
				break;
			case "Posion":
				break;
			
			
			}
		}
	}
	
	
	public void draw(Graphics2D g2) {
     BufferedImage image = null;
     switch (direction) {
     case "up":
    	 if (spriteNum==1) {
    		 image= arka; 
    	 }
    	if (spriteNum==2) {
    		image =arka; //up2 çizince onu koy ki yürüsün!!!
    	}
          break;
     case "down":
    	 if (spriteNum==1) {
    		 image= on; 
    	 }
    	if (spriteNum==2) {
    		image =on; //down2 çizince onu koy ki yürüsün!!!
    	}
    	break;
    	
     case "left":
    	 if (spriteNum==1) {
    		 image= sol; 
    	 }
    	if (spriteNum==2) {
    		image =sol; //left2 çizince onu koy ki yürüsün!!!
    	}
    	 break;
    	 
    	 
     case "right":
    	 if (spriteNum==1) {
    		 image= sag; 
    	 }
    	if (spriteNum==2) {
    		image =sag; //right2 çizince onu koy ki yürüsün!!!
    	}
    	 break;
          
     }
     g2.drawImage(image, screenX, screenY, gamepanel.tileSize, gamepanel.tileSize, null);
	}
}
