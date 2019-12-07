package day10;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ControlByKey extends Frame implements KeyListener{
	Button ctlBtn;
	
	ControlByKey()
	{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다");
				System.exit(0);
			}
		});
		setBounds(100,100,1000,800);
		
		ctlBtn = new Button("^^");
		
		setLayout(null);
		ctlBtn.setBounds(450,350,50,50);
		add(ctlBtn);
		
		ctlBtn.addKeyListener(this);
		
		setVisible(true);
	}

	
	
	
	public static void main(String[] args) {
		ControlByKey sw = new ControlByKey();
	}




	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		//System.out.println(key);
		int x = ctlBtn.getX();
		int y = ctlBtn.getY();
		System.out.println("(" + x + ", " + y + ")");
		
		if(key == 37) 
		{
			x -= 3;
			if(x<=0 || x>=1000)
				x = 500;
			
			ctlBtn.setLocation(x,y);
		}
		else if(key == 38)
		{
			y -= 3;
			if(y<=0 || y>=800)
				y = 400;
			
			ctlBtn.setLocation(x,y);
		}
		else if(key == 39)
		{
			x += 3;
			if(x<=0 || x>=1000)
				x = 500;
			
			ctlBtn.setLocation(x,y);
		}
		else if(key == 40)
		{
			y += 3;
			if(y<=0 || y>=800)
				y = 400;
			
			ctlBtn.setLocation(x,y);
		}
		else if(key == 32)
		{
			for (int i = 0; i <= 20; i++) {
				ctlBtn.setLocation(x, ctlBtn.getY() - 5);
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i=0; i<=20; i++) {
				ctlBtn.setLocation(x, ctlBtn.getY() + 5);
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}




	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
