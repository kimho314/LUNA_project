package shooting_game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShootingCanvas extends Canvas implements MouseListener, KeyListener{
	
	private int x;
	private int y;
	private Ally ally;
	private Enemy enemy;
	
	public ShootingCanvas() {
		addMouseListener(this);
		addKeyListener(this);
		
		
		ally = new Ally();
		enemy = new Enemy();

		
		new Thread(()-> {
			
			while (true) {
				try {
					ally.update();
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				repaint();
			}
			
		}).start();
	}
	
	@Override
	public void paint(Graphics g) {

		ally.draw(g,this);
		enemy.draw(g,this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Clicked");
		ally.move(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		x = ally.getPosX();
		y = ally.getPoxY();
		
		switch(e.getKeyCode())
		{
		case 37: // leftward
			x -= 3;
			break;
			
		case 38: // upward
			y -= 3;
			break;
			
		case 39: // rightward
			x += 3;
			break;
			
		case 40: // downward
			y += 3;
			break;
		}
		
		ally.move(x, y);
		repaint();		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
