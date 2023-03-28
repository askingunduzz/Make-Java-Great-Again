package snake;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class engine extends JFrame implements KeyListener{

    public snake player;
    private final Color color = new Color(0x16161d);
    private JLabel scoreBoard = new JLabel();

    public engine(int w, int h, snake s, food f){
        this.getContentPane().setBackground(this.color);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(w,h);
        this.setLayout(null);
        this.setUndecorated(true);
        this.addKeyListener(this);
        this.player = s;
        this.add(f);
        this.scoreBoard.setText(Integer.toString(this.player.score));
        this.scoreBoard.setForeground(new Color(0x00ff00));
        this.scoreBoard.setBackground(new Color(0x16161d));
        this.scoreBoard.setBounds(0,0, 50,50);
        this.scoreBoard.setFont(new Font("Calibri", Font.BOLD, 30));
        this.add(this.scoreBoard);
        for(int i = 0; i < s.body.size(); i++){
            this.add(s.body.get(i));
        }

        this.setVisible(true);
    }

    public void updateScore(){
        this.scoreBoard.setText(Integer.toString(this.player.score));
    }
    public void keyPressed(KeyEvent e){ }
    public void keyReleased(KeyEvent e){ }
    public void keyTyped(KeyEvent e){
        switch(e.getKeyChar()){
            case 'w':
                this.player.changeDir('u');
                break;
            case 's':
                this.player.changeDir('d');
                break;
            case 'd':
                this.player.changeDir('r');
                break;
            case 'a':
                this.player.changeDir('l');
                break;
        }
    }
}
