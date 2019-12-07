package role_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Missile {
	
	private int x;
	private int y;
	
	private int vx;
	private int vy;
	
	private Image img;
	private Toolkit tk;
	
	public Missile()
	{
		tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\bullet.png");
		x = 0;
		y = 0;
		vx = 0;
		vy = 0;
	}
	
	public Missile(int x, int y)
	{
		tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\bullet.png");
		this.x = x;
		this.y = y;
		vx = 0;
		vy = 0;
	}
	
	public void update() {
		
//		x += vx;
//		y += vy;
		y -= 10;
	}

	public void draw(Graphics g2, RoleCanvas roleCanvas) {
		
		g2.drawImage(img, x, y, roleCanvas);
	}
}
