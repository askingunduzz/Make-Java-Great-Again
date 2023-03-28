package main;

import entity.spice;

public class Tester {
	
	GamePanel gamepanel;
	public Tester(GamePanel gp) {
		this.gamepanel = gp;
	}
	
	
	public void checkTile(spice spice) {
		
		int enLeftWorldX= spice.worldX + spice.solidArea.x;
		int enRightWorldX= spice.worldX + spice.solidArea.x + spice.solidArea.width;
		int enTopWorldY= spice.worldY +spice.solidArea.y;
		int enBottomWorldY= spice.worldY + spice.solidArea.y + spice.solidArea.height;
		
		
		int enLeftCol = enLeftWorldX / gamepanel.tileSize;
		int enRightCol = enRightWorldX / gamepanel.tileSize;
		int enTopRow= enTopWorldY / gamepanel.tileSize;
		int enBottomRow= enBottomWorldY / gamepanel.tileSize;
		
		
		int tile1, tileNum2;
		
		
		switch( spice.direction ) {
		
		case "up":
			enTopRow = (enTopWorldY - spice.speed)/gamepanel.tileSize;
			tile1 =gamepanel.tileM.mapTileNum[enLeftCol][enTopRow];
			tileNum2 = gamepanel.tileM.mapTileNum[enRightCol][enTopRow];
			if(gamepanel.tileM.tile[tile1].collision == true || gamepanel.tileM.tile[tileNum2].collision == true) {
				
				spice.collisionOn=true;
				
			}
			break;
		case "down":
			enBottomRow = (enBottomWorldY + spice.speed)/gamepanel.tileSize;
			tile1 =gamepanel.tileM.mapTileNum[enLeftCol][enBottomRow];
			tileNum2 = gamepanel.tileM.mapTileNum[enRightCol][enBottomRow];
			if(gamepanel.tileM.tile[tile1].collision == true || gamepanel.tileM.tile[tileNum2].collision == true) {
				
				spice.collisionOn=true;
				
			}
			
			break;
		case "left":
			enLeftCol = (enLeftWorldX - spice.speed)/gamepanel.tileSize;
			tile1 =gamepanel.tileM.mapTileNum[enLeftCol][enTopRow];
			tileNum2 = gamepanel.tileM.mapTileNum[enLeftCol][enBottomRow];
			if(gamepanel.tileM.tile[tile1].collision == true || gamepanel.tileM.tile[tileNum2].collision == true) {
				
				spice.collisionOn=true;
				
			}
			
			break;
		case "right":
			enRightCol= (enRightWorldX + spice.speed)/gamepanel.tileSize;
			tile1 =gamepanel.tileM.mapTileNum[enRightCol][enTopRow];
			tileNum2 = gamepanel.tileM.mapTileNum[enRightCol][enBottomRow];
			if(gamepanel.tileM.tile[tile1].collision == true || gamepanel.tileM.tile[tileNum2].collision == true) {
				
				spice.collisionOn=true;
				
			}
			
			 break;
		
		
		
		}
		
	}

	public int checkfortheObject(spice spice, boolean girl) {
		
		
		int index = 999;
		
		for (int i =0 ; i < gamepanel.obj.length ; i++) {
			
		if (gamepanel.obj[i] != null) {
			// get entitys solid area position
			
			spice.solidArea.x=spice.worldX + spice.solidArea.x;
			spice.solidArea.y= spice.worldY + spice.solidArea.y;
			
			//get the objects solid area position
			
			gamepanel.obj[i].solidalan.x=gamepanel.obj[i].worldX + gamepanel.obj[i].solidalan.x;
			gamepanel.obj[i].solidalan.y=gamepanel.obj[i].worldY+gamepanel.obj[i].solidalan.y;
			
			switch(spice.direction) {
			case "up":
				spice.solidArea.y -= spice.speed;
				if ( spice.solidArea.intersects(gamepanel.obj[i].solidalan) ) {
					if (gamepanel.obj[i].collision ==  true) {
						spice.collisionOn = true;
					}
					if (girl==true) {
						index= i;
					}
				}
				break;
			case "down":
				spice.solidArea.y += spice.speed;
				if ( spice.solidArea.intersects(gamepanel.obj[i].solidalan) ) {
					if (gamepanel.obj[i].collision ==  true) {
						spice.collisionOn = true;
					}
					if (girl==true) {
						index= i;
					}
				}
				break;
				
			case "left":
				spice.solidArea.x -= spice.speed;
				if ( spice.solidArea.intersects(gamepanel.obj[i].solidalan) ) {
					if (gamepanel.obj[i].collision ==  true) {
						spice.collisionOn = true;
					}
					if (girl==true) {
						index= i;
					}
				}
				break;
				
			case "right":
				spice.solidArea.x += spice.speed;
				if ( spice.solidArea.intersects(gamepanel.obj[i].solidalan) ) {
					if (gamepanel.obj[i].collision ==  true) {
						spice.collisionOn = true;
					}
					if (girl==true) {
						index= i;
					}
			
				break;
				}
			}
			spice.solidArea.x= spice.solidAreaDefaultX;
			spice.solidArea.y= spice.solidAreaDefaultY;
			gamepanel.obj[i].solidalan.x=gamepanel.obj[i].solidAreaDefaultX;
			gamepanel.obj[i].solidalan.y=gamepanel.obj[i].solidAreaDefaultY;
		}
			
		}
		return index;
		
		
	}
	
	
	
	
	
	
	
	

}
