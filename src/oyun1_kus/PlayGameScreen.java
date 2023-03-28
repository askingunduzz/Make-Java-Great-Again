package oyun1_kus;



import javax.swing.*;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Color;

public class PlayGameScreen extends JPanel {
    //default reference ID
    private static final long serialVersionUID = 1L;

    //global variables
    private int screenWidth, screenHeight;
    private boolean isSplash = true;
    private int successfulJumps = 0;
    private String message = "Flappy Bird";
    private Font primaryFont = new Font("Goudy Sto" +
            "ut", Font.BOLD, 56), failFont = new Font("Calibri", Font.BOLD, 56);
    private int messageWidth = 0, scoreWidth = 0;
    private BottomPipe bp1, bp2;
    private TopPipe tp1, tp2;
    private Bird bird;


    public PlayGameScreen(int screenWidth, int screenHeight, boolean isSplash) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.isSplash = isSplash;

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(102, 255, 102)); //color for the blue sky
        g.fillRect(0, 0, screenWidth, screenHeight*7/8); //create the sky rectangle
        g.setColor(new Color(147, 136, 9)); //brown color for ground
        g.fillRect(0, screenHeight*7/8, screenWidth, screenHeight/8); //create the ground rectangle
        g.setColor(Color.BLACK); //dividing line color
        g.drawLine(0, screenHeight*7/8, screenWidth, screenHeight*7/8); //draw the dividing line

        //objects must be instantiated before they're drawn!
        if(bp1 != null && bp2 != null && tp1 != null && tp2 != null) {
            g.drawImage(bp1.getPipe(), bp1.getX(), bp1.getY(), null);
            g.drawImage(bp2.getPipe(), bp2.getX(), bp2.getY(), null);
            g.drawImage(tp1.getPipe(), tp1.getX(), tp1.getY(), null);
            g.drawImage(tp2.getPipe(), tp2.getX(), tp2.getY(), null);
        }

        if(!isSplash && bird != null) {
            g.drawImage(bird.getBird(), bird.getX(), bird.getY(), null);
        }

        //needed in case the primary font does not exist
        try {
            g.setFont(primaryFont);
            FontMetrics metric = g.getFontMetrics(primaryFont);
            messageWidth = metric.stringWidth(message);
            scoreWidth = metric.stringWidth(String.format("%d", successfulJumps));
        }
        catch(Exception e) {
            g.setFont(failFont);
            FontMetrics metric = g.getFontMetrics(failFont);
            messageWidth = metric.stringWidth(message);
            scoreWidth = metric.stringWidth(String.format("%d", successfulJumps));
        }

        g.drawString(message, screenWidth/2-messageWidth/2, screenHeight/4);

        if(!isSplash) {
            g.drawString(String.format("%d", successfulJumps), screenWidth/2-scoreWidth/2, 50);}
        }
        /*
        String messages = "You Failed...\n"+
                "You have to continue main game  : "
    ;
JOptionPane.showMessageDialog(this,messages);
//JComponent.AccessibleJComponent
System.exit(0);

    }
    */


    public void setBottomPipe(BottomPipe bp1, BottomPipe bp2) {
        this.bp1 = bp1;
        this.bp2 = bp2;
    }


    public void setTopPipe(TopPipe tp1, TopPipe tp2) {
        this.tp1 = tp1;
        this.tp2 = tp2;
    }


    public void setBird(Bird bird) {
        this.bird = bird;
    }


    public void incrementJump() {
        successfulJumps++;
    }

    public int getScore() {
        return successfulJumps;
    }


    public void sendText(String message) {
        this.message = message;
    }
}

