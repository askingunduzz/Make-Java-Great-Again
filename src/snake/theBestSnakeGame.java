package snake;



import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Color;
public class theBestSnakeGame{
    public static void main(String[] a) throws Exception{
        int size = 600;
        snake s = new snake(3, size/2, size/10, size);
        food f = new food(size, size/10);
        engine e = new engine(size,size,s,f);
        int delay = 500;

        while(true){
            s.move();
            if(s.dead()){

                e.setVisible(false);
             //   System.out.println("YOUR SCORE IS " + s.score);
              //  System.out.print("Do you want to continue(y/n): ");
                String cont = new Scanner(System.in).nextLine();
                if(cont.toLowerCase().charAt(0) == 'y'){
                    s = new snake(3, size/2, size/10, size);
                    f = new food(size, size/10);
                    e = new engine(size,size,s,f);
                }
                else{
                    System.exit(0);
                }

            }
            if(s.eatsFood(f)){
                e.add(s.body.get(s.body.size()-1));
                delay -= 10;
                e.updateScore();
            }
            Thread.sleep(delay);
        }
    }
}

