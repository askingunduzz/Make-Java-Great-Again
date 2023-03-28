package main;

import object.OBJ_Ax;
import object.OBJ_Door;
import object.OBJ_Posion;

public class AssetSetter {
GamePanel gamepanel;


public AssetSetter(GamePanel gp) {
	this.gamepanel = gp;
	
}


public void SetObject() {
	gamepanel.obj[0]= new OBJ_Ax();
	gamepanel.obj[0].worldX=8*gamepanel.tileSize;
	gamepanel.obj[0].worldY=42*gamepanel.tileSize;
//en alttaki
	
	gamepanel.obj[1]= new OBJ_Ax();
	gamepanel.obj[1].worldX=23*gamepanel.tileSize;
	gamepanel.obj[1].worldY=10*gamepanel.tileSize;
	
	gamepanel.obj[2]= new OBJ_Ax();
	gamepanel.obj[2].worldX=44*gamepanel.tileSize;
	gamepanel.obj[2].worldY=41*gamepanel.tileSize;
	
	gamepanel.obj[3]= new OBJ_Door();
	gamepanel.obj[3].worldX=10*gamepanel.tileSize;
	gamepanel.obj[3].worldY=11*gamepanel.tileSize;

	
	gamepanel.obj[4]= new OBJ_Door();
	gamepanel.obj[4].worldX=8*gamepanel.tileSize;
	gamepanel.obj[4].worldY=27*gamepanel.tileSize;
	
	gamepanel.obj[5]= new OBJ_Door();
	gamepanel.obj[5].worldX=11*gamepanel.tileSize;
	gamepanel.obj[5].worldY=22*gamepanel.tileSize;
	
	gamepanel.obj[6]= new OBJ_Posion();
	gamepanel.obj[6].worldX=10*gamepanel.tileSize;
	gamepanel.obj[6].worldY=6*gamepanel.tileSize;
	
	
	
	
  }


}
