package snake;


import javax.swing.JLabel;
import java.awt.Color;
import java.util.Random;
public class food extends JLabel{
    private Color color = new Color(0xffffff);
    private int bSize;
    private int size;
    private Random r = new Random();

    public food(int bsize, int size){
        this.size = size;
        this.bSize = bsize;
        this.setBounds(Math.abs(r.nextInt() % (this.bSize/this.size))*size, Math.abs(r.nextInt() % (this.bSize/this.size))*size,size,size);

        this.setBackground(this.color);
        this.setOpaque(true);
    }

    public void replace(){

        this.setLocation(Math.abs(r.nextInt() % (this.bSize/this.size))*size, Math.abs(r.nextInt() % (this.bSize/this.size))*size);
    }

}


