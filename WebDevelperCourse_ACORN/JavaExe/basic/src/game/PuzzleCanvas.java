package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;


public class PuzzleCanvas extends Canvas {
	int[] pos = new int[9];
	
	public PuzzleCanvas()
	{
		
		for(int i=0; i<pos.length; i++)
			pos[i] = i;
		
		
		Random rand = new Random();
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < 10; i++) {
			p1 = rand.nextInt(9);
			p2 = rand.nextInt(9);
			if(p1 == p2)
				continue;

			int temp;
			temp = pos[p1];
			pos[p1] = pos[p2];
			pos[p2] = temp;
			
			System.out.printf("p1 : %d, p2 : %d\n", p1, p2);
			for(int cnt=0; cnt<9; cnt++)
				System.out.printf("[%d] ", pos[cnt]);
			System.out.println("");
		}		
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\foto9.jpg");
		
		int x = 0;
		int y = 0;
		int w = 200;
		int h = 200;
		// 2차배열의 열의 개수
		int dCol = 3;
		
		
		for(int i=0; i<pos.length; i++)
		{
			g.drawImage(img, x+(w*(pos[i]%dCol)), y+(h*(pos[i]/dCol)), x+w+(w*(pos[i]%dCol)), y+h+(h*(pos[i]/dCol)), 
					x+(w*(i%dCol)),  y+(h*(i/dCol)), x+w+(w*(i%dCol)), y+h+(h*(i/dCol)), this);
			//g.drawImage(img, x+(w*(i%3)), y+(h*(i/3)), x+w+(w*(i%3)), y+h+(h*(i/3)), x,  y, x+w, y+h, this);
		}
	}
}
