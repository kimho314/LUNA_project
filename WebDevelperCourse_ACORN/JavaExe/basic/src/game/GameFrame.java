package game;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameFrame extends Frame {
	
	//private Fighter fighter;
	private Canvas canvas;
	
	public GameFrame()
	{
		setBounds(0,0,1334,750);
		
		
		//canvas = new GameCanvas();
		//canvas = new PuzzleCanvas2();
		//canvas = new LottoCanvas();
		canvas = new PuzzleCanvas3();
		add(canvas);
		//fighter = new Fighter();
		
		setVisible(true);
	}
	
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		Image img = tk.getImage("C:\\eclipse\\workspace\\basic\\src\\images\\space\\fighter.png");
//		
//		g.drawImage(img, 100, 0, this);
//		
//	}
}
