package KillRoot;

import javax.swing.*;
import java.awt.*;

public class OyunEkrani extends JFrame {
    public OyunEkrani(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        OyunEkrani ekran = new OyunEkrani("Kill the Root");
        ekran.setResizable(false);
        ekran.setFocusable(false);//we don't want all processes to be on Jframe


        ekran.setSize(800,600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Oyun oyun = new Oyun();
        oyun.requestFocus();//Allows JPanel to understand operations from the keyboard

        oyun.addKeyListener(oyun);// KeyListener interface i allows to understand operations from the keyboard.


        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);//Allows JPanel to understand keyboard operations


        ekran.add(oyun);
        ekran.setVisible(true);


    }
}
