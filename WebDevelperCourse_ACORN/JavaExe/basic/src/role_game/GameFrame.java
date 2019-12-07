package role_game;

import java.awt.Canvas;
import java.awt.Frame;


public class GameFrame extends Frame{
	private Canvas canvas;
	
	public GameFrame()
	{
		setSize(700, 800);
		
		canvas = new RoleCanvas();
		canvas.setFocusable(true);
		canvas.requestFocus();
		add(canvas);
		
		setVisible(true);
		addWindowListener(new GameWindowListener());
	}
}
