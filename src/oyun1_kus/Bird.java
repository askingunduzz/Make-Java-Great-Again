package oyun1_kus;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


// kuşun boyutut küçültülse çok iyi olur sürekli çarpıyor
//oyunun kendi başlangıç menüsüne insutrcions gibi çok kısa bir şey eklesek çok hoş olur
// 5 puana ulaşınca oyun kendini yapatsın
// retry butonu?
// ağacın arka planı kaldırılıcak
//maze i öyle ayarlamaylıyız ki yan oyunlara gelmeden finish e gelemesin

public class Bird {
    //global variables
    private Image flappyBird;
    private int xLoc = 0, yLoc = 0;


    public Bird(int initialWidth, int initialHeight) {
       // flappyBird = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("C:\\Users\\askin\\OneDrive\\Masaüstü\\asli oyun\\flappy.jpg"));
        //topPipe = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("C:\\Users\\askin\\OneDrive\\Masaüstü\\asli oyun\\roots.jpg"));
        try {
            flappyBird = ImageIO.read(getClass().getResourceAsStream("/oyun1/plane.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        scaleBird(initialWidth, initialHeight);

    }


    public void scaleBird(int width, int height) {
        flappyBird = flappyBird.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }


    public Image getBird() {
        return flappyBird;
    }


    public int getWidth() {
        try {
            return flappyBird.getWidth(null);
        }
        catch(Exception e) {
            return -1;
        }
    }


    public int getHeight() {
        try {
            return flappyBird.getHeight(null);
        }
        catch(Exception e) {
            return -1;
        }
    }


    public void setX(int x) {
        xLoc = x;
    }


    public int getX() {
        return xLoc;
    }


    public void setY(int y) {
        yLoc = y;
    }

    public int getY() {
        return yLoc;
    }


    public Rectangle getRectangle() {
        return (new Rectangle(xLoc, yLoc, flappyBird.getWidth(null), flappyBird.getHeight(null)));
    }


    public BufferedImage getBI() {
        BufferedImage bi = new BufferedImage(flappyBird.getWidth(null), flappyBird.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.getGraphics();
        g.drawImage(flappyBird, 0, 0, null);
        g.dispose();
        return bi;
    }
}