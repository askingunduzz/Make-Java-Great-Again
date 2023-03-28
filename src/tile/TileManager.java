package tile;

import main.GamePanel;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

GamePanel gamepanel;
public Tile[] tile;
public int mapTileNum[][];


	public TileManager(GamePanel gp) {
		this.gamepanel = gp;
		
		tile= new Tile[10];
		mapTileNum= new int [gp.maxWorldCol] [gp.maxWorldRow];
		
		getTileImage();
		
		loadMap("/world01.txt");
	}

	
public void getTileImage() {
try	{
	
tile[0]= new Tile();
tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tiles/grass.jpg"));


tile[1]= new Tile();
tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tiles/ppwall.jpeg"));
tile[1].collision= true;


tile[2]= new Tile();
tile[2].image=ImageIO.read(getClass().getResourceAsStream("/tiles/su.jpg"));
tile[2].collision= true;

tile[3]= new Tile();
tile[3].image=ImageIO.read(getClass().getResourceAsStream("/tiles/dirt.png"));

tile[4]= new Tile();
tile[4].image=ImageIO.read(getClass().getResourceAsStream("/tiles/oo.png"));
tile[4].collision=true;

tile[5]= new Tile();
tile[5].image=ImageIO.read(getClass().getResourceAsStream("/tiles/sand.jpg"));



		
}catch (IOException e)	{
	e.printStackTrace();
}	
	
	
}


public void loadMap(String filePath) {
	
	try {
		
		InputStream is = getClass().getResourceAsStream(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		int col=0;
		int row=0;
		
		
		while(col < gamepanel.maxWorldCol && row < gamepanel.maxWorldRow) {
			
			String line = br.readLine();
			
			while(col< gamepanel.maxWorldCol) {
				
				String numbers[]= line.split(" ");
				
				int num = Integer.parseInt(numbers[col]);
				mapTileNum[col][row] = num;
				col++;
			
			}
			if (col== gamepanel.maxWorldCol) {
				col=0;
				row++;
			}
			
		}
		
		br.close();
		
	}catch (Exception e) {
		
	}
}


public void draw(Graphics2D g2) {
	
	int worldColum =0;
	int worldRow=0;
	
	
	while (worldColum<gamepanel.maxWorldCol && worldRow < gamepanel.maxWorldRow) {
		
		int tileNum= mapTileNum[worldColum][worldRow];
		
		int worldX = worldColum * gamepanel.tileSize;
		int worldY = worldRow * gamepanel.tileSize;
		int screenX = worldX-gamepanel.girl.worldX + gamepanel.girl.screenX;
		int screenY = worldY-gamepanel.girl.worldY + gamepanel.girl.screenY;
		
		if (worldX + gamepanel.tileSize> gamepanel.girl.worldX-gamepanel.girl.screenX && worldX -gamepanel.tileSize < gamepanel.girl.worldX+ gamepanel.girl.screenX 
		&& worldY +gamepanel.tileSize > gamepanel.girl.worldY-gamepanel.girl.screenY && worldY -gamepanel.tileSize < gamepanel.girl.worldY+ gamepanel.girl.screenY) {
			
		g2.drawImage(tile[tileNum].image,screenX,screenY,gamepanel.tileSize,gamepanel.tileSize,null);
		}
		
		worldColum++;

		
		if (worldColum== gamepanel.maxWorldCol) {
			worldColum=0;
	
			worldRow++;
			
		}
	}

}



}

