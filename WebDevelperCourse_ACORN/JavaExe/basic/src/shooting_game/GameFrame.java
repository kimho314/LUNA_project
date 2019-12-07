package shooting_game;

import java.awt.Canvas;
import java.awt.Frame;

public class GameFrame extends Frame {
	
	private Canvas canvas;
	
	public GameFrame()
	{
		setSize(500, 700);
		
		canvas = new ShootingCanvas();
		canvas.setFocusable(true);
		canvas.requestFocus();
		add(canvas);
		
		setVisible(true);
		
		addWindowListener(new GameWindowListener());
	}
}
