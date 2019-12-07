package role_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Kid {
	
	private int x;
	private int y;
	
	private int vx;
	private int vy;
	
	private int dx;
	private int dy;
	
	private Image img;
	private int imgIndex;
	private Toolkit tk;
	
	private int w;
	private int h;
	
	private final static int OFFSET_WIDTH;
	private final static int OFFSET_HEIGHT;
	
	private int timeForReady;
	
	static
	{
		OFFSET_WIDTH = 32;
		OFFSET_HEIGHT = 32;
	}
	
	public Kid()
	{
		x = 250;
		y = 300;
		w = h = 64;
		timeForReady = 0;
		
		tk = Toolkit.getDefaultToolkit();
		//img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\kid.jpg");
		img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\fighter.png");
		imgIndex = 3;
	}

	public void draw(Graphics g, RoleCanvas roleCanvas) {
		
		g.drawImage(img, x-OFFSET_WIDTH, y, x+w-OFFSET_WIDTH, y+h,
				0+(w*(imgIndex)), 0, 0+(w*(imgIndex+1)), 0+h,  roleCanvas);
		g.drawRect(x-OFFSET_WIDTH, y, w, h);
	}
	
	
	public void update() {
		
		x += vx;
		y += vy;
		
		if(timeForReady > 0)
		{
			timeForReady--;
		}
		
		if(x >= 700 - 64)
		{
			x = 700 - 64;
		}
		if(x <= 0)
		{
			x = 0;
		}
		
		if(y >= 800 - (64*2))
		{
			y = 800 - (64*2);
		}
		if(y <= 0)
		{
			y = 0;
		}
	}

	public void move(Direction direction) {

		switch (direction) {
		case LEFT:
			imgIndex--;
			x -= 5;
			break;

		case UP:
			imgIndex = 3;
			y -= 5;
			break;

		case RIGHT:
			imgIndex++;
			x += 5;
			break;

		case DOWN:
			imgIndex = 3;
			y += 5;
			break;
		}

		if (imgIndex < 0)
			imgIndex = 0;
		if (imgIndex > 6)
			imgIndex = 6;

	}
	
	
	
	public void move(int x, int y)
	{
		dx = x;
		dy = y;
	}

	public Missile fire() {
		
		if(timeForReady == 0)
		{
			Missile m = new Missile(x, y);
			timeForReady = 10;
			return m;
		}
		
		return null;
	}

	
}
