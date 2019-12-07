package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Puzzle2 {
	
	private int x;
	private int y;
	private int w;
	private int h;
	
	private int sx;
	private int sy;
	
	Toolkit tk;
	Image img;
	
	Puzzle2()
	{
		w = 200;
		h = 200;
		
		tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\foto9.jpg");
	}


	public void setPos(int i) {
		// TODO Auto-generated method stub
		x = (i%3)*200;
		y = (i/3)*200;
	}


	public void setSrc(int i) {
		// TODO Auto-generated method stub
		sx = (i%3)*200;
		sy = (i/3)*200;
	}


	public void draw(Graphics g, PuzzleCanvas3 puzzleCanvas3) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, x+w, y+h, sx, sy, sx+w, sy+h, puzzleCanvas3);
	}
	
}
