package shooting_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ally {
	private int x;
	private int y;
	private Image img;
	
	private int vx;
	private int vy;
	private int dx;
	private int dy;
	
	public Ally()
	{
		x = 100;
		y = 100;
		vx = 0;
		vy = 0;
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\fighter.png");
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

	public void move(int x, int y) {
		this.dx = x;
		this.dy = y;
		
//		vx = (dx-this.x) / 15;
//		vy = (dy-this.y) / 15;
		
		double w = (double)(dx - this.x);
		double h = (double)(dy - this.y);
		double d = Math.sqrt((w*w) + (h*h));
		vx = (int)(w/d*10);
		vy = (int)(h/d*10);
		double tmp_vx = (double)w/d*10;
		double tmp_vy = (double)h/d*10;
		System.out.println("(" + this.x + ", " + this.y + ")" + " dx : " + dx + " dy : " + dy + " d : " + d + " w : " + w + " h: " + h);
		System.out.println(tmp_vx + ", " + tmp_vy);
	}
	
	public void update()
	{			
		x += vx;
		y += vy;
		
		if(((x+30) >= dx) && ((x-30) <= dx) && ((y+30) >= dy) && ((y-30) <= dy))
		{
			vx = 0;
			vy = 0;
		}
	}
}
