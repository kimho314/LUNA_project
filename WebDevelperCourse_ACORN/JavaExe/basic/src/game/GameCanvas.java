package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameCanvas extends Canvas {
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		//Image img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\fighter.png");
		Image img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\foto9.jpg");
		
		//g.drawImage(img, 100, 0, this);
		
		{
			int x = 0;
			int y = 0;
			int w = 200;
			int h = 200;
		
			g.drawImage(img, x, y, x+w, y+h, 0, 0, 200, 200, this);
		}
		
		{
			int x = 200;
			int y = 200;
			int w = 200;
			int h = 200;
		
			g.drawImage(img, x, y, x+w, y+h, x, y, x+w, y+h, this);
		}
		
		{
			int x = 0;
			int y = 0;
			int w = 200;
			int h = 200;
		
			g.drawImage(img, x+w, y, x+w+w, y+h, 0, 0+h, 200, 200+h, this);
		}
		
		{
			int x = 0;
			int y = 0;
			int w = 200;
			int h = 200;
		
			g.drawImage(img, x, y+h, x+w, y+h+h, 0+w, 0, 200+w, 200, this);
		}
	}
}
