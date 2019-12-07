package role_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Background {
	private int x;
	private int y;
	private Image img;
	private Toolkit tk;
	
	private final static int OFFSET_WIDTH;
	private final static int OFFSET_HEIGHT;
	
	static
	{
		OFFSET_WIDTH = 720;
		OFFSET_HEIGHT = 1280;
	}
	
	public Background()
	{
		x = 0;
		y = 0;
	
		tk = Toolkit.getDefaultToolkit();
		//img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\배경이미지.jpg");
		img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\우주배경.jpg");
	}

	public void draw(Graphics g, RoleCanvas roleCanvas) {
		g.drawImage(img, x, y, roleCanvas);		
		//g.drawImage(img, x, y - 800, roleCanvas);		
		g.drawImage(img, x, y - OFFSET_HEIGHT, roleCanvas);		
		
	}

	public void update() {
		y+=2;
				
		if((y+OFFSET_HEIGHT) >= (OFFSET_HEIGHT*2))
		{
			y = 0;			
		}
	}
}
