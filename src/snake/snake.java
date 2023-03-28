package snake;


import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
public class snake{
    public ArrayList<JLabel> body = new ArrayList();
    private char direction = 'r';
    private int size;
    private int bSize;
   public int score;
    private int color = 0xff0000;

    public snake(int length, int begin, int s, int b){
        this.score = 0;
        this.size = s;
        this.bSize = b;
        for(int i = 0; i < length; i++){
            JLabel jl = new JLabel();
            jl.setBounds(begin - this.size*(i+1), begin,this.size,this.size);
            jl.setBackground(new Color(this.color));
            jl.setOpaque(true);
            this.body.add(jl);
        }
    }

    public void changeDir(char c){
        if((this.direction != 'u') && (this.direction != 'd') && (c == 'd' || c == 'u')){
            this.direction = c;
        }
        else if((this.direction != 'l') && (this.direction != 'r') && (c == 'r' || c == 'l')){
            this.direction = c;
        }
    }

    private void enlarge(){
        JLabel j = new JLabel();
        j.setBounds(-1,-1,this.size,this.size);
        j.setBackground(new Color(this.color));
        j.setOpaque(true);
        this.body.add(j);
    }
   /* private int scoreF = 5;
    private int scoreDir = -1;*/
/*private void restart(){
    snake.dispose();
    new Game();
    repaint();
}*/
    public boolean eatsFood(food f){
      /* for(int i = scoreF; i>=0 ; i--) {
            if (scoreF != 0 && snake.dead()) {
                //return oyunu baştan başlat ve bitirene kadar oynat

            } else {//oyunu kapat
                System.exit(0);
            }

            if (scoreF == 0) {
                // return oyunu kapat System.exit(0);
            } else { //oyuna devam et

            }
            scoreF += scoreDir;
            return true;
        } return false;}*/
        int X = this.body.get(0).getX();
        int Y = this.body.get(0).getY();
        if((Math.abs(X - f.getX()) < this.size) && (Math.abs(Y - f.getY()) < this.size)){
            this.score++;
            f.replace();
            this.enlarge();
            return true;
        }
        return false;
    }

    public void move(){
        for(int i = this.body.size() -1; i > 0; i--){
            this.body.get(i).setLocation(this.body.get(i-1).getX(),this.body.get(i-1).getY());
        }

        int x = this.body.get(0).getX();
        int y = this.body.get(0).getY();

        switch(this.direction){
            case 'r':
                this.body.get(0).setLocation(x + this.size, y);
                break;
            case 'l':
                this.body.get(0).setLocation(x - this.size, y);
                break;
            case 'd':
                this.body.get(0).setLocation(x , y+ this.size);
                break;
            case 'u':
                this.body.get(0).setLocation(x, y- this.size);
                break;
        }

    }

    private boolean ateSelf(){
        int x = this.body.get(0).getX();
        int y = this.body.get(0).getY();

        for(int i = 1; i < this.body.size(); i++){
            int X = this.body.get(i).getX();
            int Y = this.body.get(i).getY();

            if(X == x && Y == y){
                return true;
            }

        }
        return false;

    }

    private boolean outOfB(){
        int x = this.body.get(0).getX();
        int y = this.body.get(0).getY();

        return (x < 0) || (x > this.bSize-1) || (y < 0) || (y > this.bSize-1);

    }

    public boolean dead(){
        boolean eats = this.ateSelf();
        boolean outOfBounds = this.outOfB();
        return eats || outOfBounds;
    }


}

