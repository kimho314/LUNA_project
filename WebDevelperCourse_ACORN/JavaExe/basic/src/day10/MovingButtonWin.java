package day10;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MovingButtonWin extends Frame implements MouseMotionListener{
	Label title;
	Button yesBtn, noBtn;
	
	MovingButtonWin()
	{
		setBounds(100,100,600,400);
		
		setLayout(null);
		title = new Label("당신은 잘생겼다고 생각하십니까?", Label.CENTER);
		title.setSize(400,100);
		title.setLocation(100,50);
		title.setBackground(Color.gray);
		add(title);
		
		yesBtn = new Button("YES");
		noBtn = new Button("NO");
		yesBtn.setBounds(200,150,100,50);
		noBtn.setBounds(300,150,100,50);
		add(yesBtn); 
		add(noBtn);
		
		addMouseMotionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다");
				System.exit(0);
			}
		});
		
		setVisible(true);
		
		
	}

	
	
	
	public static void main(String[] args) {
		MovingButtonWin sw = new MovingButtonWin();
	}




	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		//System.out.print("마우스 위치 : " + "(" + x + ", " + y + ")" + " ");
		int bx = yesBtn.getX();
		int by = noBtn.getY();
		//System.out.println("버튼의 위치 : " + "(" + bx + ", " + by + ")");
		double d = Math.sqrt((bx-x)*(bx-x) + (by-y)*(by-y));
		System.out.println("Distance : " + d);
		if(d < 120)
		{
			yesBtn.setLocation((int)Math.random()*600, (int)Math.random()*400);
		}
		
	}
}
