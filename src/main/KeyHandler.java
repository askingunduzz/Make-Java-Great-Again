package main;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class KeyHandler implements KeyListener {

	
	public boolean upPressed, downPressed , leftPressed , rightPressed;
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int kod_alim = e.getKeyCode();
		
		if (kod_alim == KeyEvent.VK_W) {
			upPressed = true;
		}
		
	    if (kod_alim == KeyEvent.VK_S) {
			downPressed = true;
		}
	    
	    if (kod_alim == KeyEvent.VK_A) {
			leftPressed = true;
		}
	   
	    if (kod_alim == KeyEvent.VK_D) {
			rightPressed = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int kod_alim = e.getKeyCode();
		
		if (kod_alim == KeyEvent.VK_W) {
			upPressed = false;
		}
		
	    if (kod_alim == KeyEvent.VK_S) {
			downPressed = false;
		}
	    
	    if (kod_alim == KeyEvent.VK_A) {
			leftPressed = false;
		}
	   
	    if (kod_alim == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
