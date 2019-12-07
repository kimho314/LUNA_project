package shooting_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Enemy {
	private int x;
	private int y;
	private Image img;
	
	public Enemy()
	{
		x = 0;
		y = 0;
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\enemy.png");
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;		
	}
	
	public int getPosX()
	{
		return x;
	}
	
	public int getPoxY()
	{
		return y;
	}
	
	public void draw(Graphics g, ShootingCanvas shootingCanvas) {
		g.drawImage(img, x, y, shootingCanvas);		
	}
}
