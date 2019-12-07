package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class LottoCanvas extends Canvas{
	
	private int[] lotto = {1,3,5,9,10,12};
	
	public LottoCanvas()
	{
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\cards.png");
		
		int w = 334;
		int h = 440;
		for(int i=0; i<lotto.length; i++)
		{
			int x = (i%13)*(w/2);
			int y = (i/13)*(h/2);
			
			
			int sx = ((lotto[i]-1)%13)*w;
			int sy = ((lotto[i]-1)/13)*h;
			
			g.drawImage(img, x, y, x+(w/2), y+(h/2), sx, sy, sx+w, sy+h, this);
		}
	}

}
