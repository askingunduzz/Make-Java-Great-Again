package main;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

import entity.girl;
import object.SuperObject;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable{

	// SCREEN SETTINGS
	
	final int originalTileSize = 16; // 16x16 tile
	final int ss=3;
	
	public final int tileSize =  originalTileSize*ss; // 48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow=12;
	public final int screenWidth = tileSize* maxScreenCol; //768 pixels
	public final int screenHeight = tileSize*maxScreenRow; //578 pixels
	
	//WORLD SETTINGS
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow=50;
	public final int worldWidth= tileSize* maxWorldCol;
	
	public final int worldHeight = tileSize*maxWorldRow;
	
	
	int FPS_score = 60;
	TileManager tileM = new TileManager(this);
	
	KeyHandler keyH = new KeyHandler();
	Thread gamestart;
	
	public Tester cChecker = new Tester(this);
	public  AssetSetter aSetter = new AssetSetter(this);
	public girl girl = new girl(this,keyH);
	
	public SuperObject obj[]= new SuperObject[10];
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.pink);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}

	public void startGame() {
		
		aSetter.SetObject();
		
	}
	
	public void startGameThread() {
		gamestart = new Thread(this);
		gamestart.start();	
		
	}
	

	/*public void run() {
		// TODO Auto-generated method stub
		
		double drawInterval = 1000000000 /FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		
		
		while (gameThread != null) {
			
			update();
			
			repaint();
			
			
			
			
		try {
			double remainingTime = nextDrawTime -System.nanoTime();
			remainingTime = remainingTime / 1000000;
			
			if (remainingTime <0 ) {
				
				remainingTime = 0;
			}
			
			Thread.sleep((long) remainingTime);
			
			nextDrawTime += drawInterval;
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		
	}
	*/
	
	public void run() {
		
	double drawingofInt = 1000000000 / FPS_score;
	double delta_method = 0;
	double olc = System.nanoTime();
	double currentTime;
	long time = 0;
	int drawingofCount = 0;
	
	
	while (gamestart != null) {
		currentTime = System.nanoTime();
				
		delta_method += (currentTime - olc)/ drawingofInt;
		time += (currentTime - olc);
		olc = currentTime;
		
		if(delta_method >= 1) {

			guncelleme();
			repaint();
			delta_method--;
			drawingofCount++;
		}
		if (time >= 1000000000) {
			drawingofCount=0;
			time = 0;
		}
	
	}
	
	}
	
	
	
	public void guncelleme() {
	
		girl.guncelleme();
	}
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		
		Graphics2D gg = (Graphics2D)g;
		
		tileM.draw(gg);
	
		for (int i = 0; i <obj.length;i++) {
			
			if(obj[i]!=null) {
				
				obj[i].draw(gg,this);
			}
		}
		
	
		girl.draw(gg);
		
		gg.dispose();
		
	}
	
	
	
}