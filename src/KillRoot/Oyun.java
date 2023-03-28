package KillRoot;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;

import main.KeyHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
class Fıre {//fires will be created and assigned to arraylist


    private int x;//Our fire will try to move forward every time Action Perform runs


    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Fıre(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Oyun extends JPanel implements KeyListener, ActionListener {
        //KeyListener interface i allows to enter operations on the keyboard.

        //These two interfaces directly give the game a keyboard feature and allow the balls in the game to move.

       Timer timer = new Timer(5,this);
        private int elapsedTime = 0;
        private int numberOfShots = 0;
        private BufferedImage image;//
    //Used ArrayList to hold fires thrown

    private ArrayList<Fıre> atesler = new ArrayList<Fıre>();
    private int atesdirY = 1;
    private int rootX = 0;//sets to go left and right and the ball starts from 0a0 at first


    //We will then increase topX by 1, so the ball will start to move to the right continuously.

    //every time there is an ActionPerform or every 5 or 10 milliseconds the ball will change x position

    private int rootdirX = 2;
    private int StoneX
            = 0;//tells where the spaceship starts


    private int dirSpaceX = 20;//Allows the Spaceship to advance 20 units per move


public boolean checkIf(){
    for(Fıre ates : atesler){
        if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle(rootX,0,20,20))){
   return true; }
}return false;}

KeyHandler keyH = new KeyHandler();

    public Oyun() {
   

        try {
            image = ImageIO.read(new FileImageInputStream(new File("/Users/Berx/Desktop/fgf.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        timer.start();
        setBackground(Color.BLACK);
        
        
        
    	//	this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    		this.setBackground(Color.green);
    		this.setDoubleBuffered(true);
    		this.addKeyListener(keyH);
    		this.setFocusable(true);
    	


    }

    @Override//implemented from JPanel
    public void paint(Graphics g) {//Used to draw shapes on JPanel


        super.paint(g);
        elapsedTime +=5;
        g.setColor(Color.red);
        g.fillOval(rootX,0,20,20);
        g.drawImage(image,StoneX,490,image.getWidth()/3,image.getHeight()/3,this);
        //g.drawImage(image2,0,0,image2.getWidth()/3,image2.getHeight()/3,this);

        for(Fıre ates : atesler){
           if( ates.getY() < 0){
               atesler.remove(ates);
           }
        }
        g.setColor(Color.GRAY);
        for(Fıre ates : atesler){
            g.fillRect(ates.getX(),ates.getY(),10,20);
        }
        if(checkIf()){
            timer.stop();
            String message = "You fired at the root...\n"+
                             "Number Of Shots : " + numberOfShots +
                             "The Passing Time: " + elapsedTime / 1000.0;
            JOptionPane.showMessageDialog(this,message);
            System.exit(0);
        }




    }               //When we repaint, the paint method is called again. When ActionPerformed, and shapes are drawn
    @Override       //Repaint is called at the end and runs paint again and draws all the shapes


    public void repaint() {
        super.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Fıre ates : atesler){
            ates.setY(ates.getY()-atesdirY);

        }

        rootX += rootdirX;
        if(rootX >= 750){
            rootdirX = -rootdirX;


        }if(rootX <= 0){
            rootdirX = -rootdirX;

        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c==KeyEvent.VK_LEFT){
            if(StoneX <= 0){
                StoneX = 0;
            }else{
                StoneX -= dirSpaceX;
            }

        } else if (c == KeyEvent.VK_RIGHT) {
            if(StoneX >= 750){
                StoneX = 750;
            }else {
                StoneX += dirSpaceX;
            }

        } else if (c == KeyEvent.VK_CONTROL) {
            atesler.add(new Fıre(490,StoneX
                    +15));
            numberOfShots++;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
	Thread gameThread;

	
	/*
	public void startGameThread() {
		
		gameThread = new Thread();
		gameThread.start();	
		
	}
	*/
}
