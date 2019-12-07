package day10;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MovingRobot extends Frame implements KeyListener{
	Button[] btnRobot;
	int[] origX = new int[6];
	int[] origY = new int[6];
	
	MovingRobot()
	{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다");
				System.exit(0);
			}
		});
		setBounds(100,100,1000,800);
		
		// 0 : head
		// 1 : body
		// 2 : left arm
		// 3 : right arm
		// 4 : left leg
		// 5 : right leg
		btnRobot = new Button[6];
		setLayout(null);

		
		btnRobot[0] = new Button("^^");
		btnRobot[1] = new Button("B");
		btnRobot[2] = new Button("LA");
		btnRobot[3] = new Button("RA");
		btnRobot[4] = new Button("LL");
		btnRobot[5] = new Button("RL");
		
		btnRobot[0].setBounds(50,550,50,50);
		btnRobot[1].setBounds(50,600,50,100);
		btnRobot[2].setBounds(30,600,20,50);
		btnRobot[3].setBounds(100,600,20,50);
		btnRobot[4].setBounds(50,700,25,50);
		btnRobot[5].setBounds(75,700,25,50);
		
		
		for(int i=0; i<btnRobot.length; i++)
		{
			origX[i] = btnRobot[i].getX();
			origY[i] = btnRobot[i].getY();
			add(btnRobot[i]);
			btnRobot[i].addKeyListener(this);
		}
		
	
		
		setVisible(true);
	}

	
	
	
	public static void main(String[] args) {
		MovingRobot sw = new MovingRobot();
	}




	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		int[] x = new int[6];
		int[] y = new int[6];
		
		
		for(int i=0; i<6; i++)
		{
			x[i] = btnRobot[i].getX();
			y[i] = btnRobot[i].getY();
			//System.out.println("key[" + i + "] : " + "(" + x[i] + ", " + y[i] + ")");
		}

		
		
		if(key == 37) // leftward
		{
			if(x[3] <= 0)
			{
				for(int i=0; i<6; i++)
				{
					x[i] += 1000;
					btnRobot[i].setLocation(x[i], y[i]);
				}
			}
			else {
				for (int i = 0; i < 6; i++) {
					x[i] -= 5;

					btnRobot[i].setLocation(x[i], y[i]);
				}
			}
		}
		else if(key == 38) // upward
		{
			if(y[4] <= 0)
			{
				for(int i=0; i<6; i++)
				{
					y[i] += 800;
					btnRobot[i].setLocation(x[i], y[i]);
				}
			}
			else {
				for (int i = 0; i < 6; i++) {
					y[i] -= 5;

					btnRobot[i].setLocation(x[i], y[i]);
				}
			}
		}
		else if(key == 39) // rightward
		{
			if(x[2] >= 1000)
			{
				for(int i=0; i<6; i++)
				{
					x[i] -= 1000;
					btnRobot[i].setLocation(x[i],y[i]);
				}
			}
			else {
				for (int i = 0; i < 6; i++) {
					x[i] += 5;

					btnRobot[i].setLocation(x[i], y[i]);
				}
			}
		}
		else if(key == 40) // downward
		{
			if(y[0] >= 800 )
			{
				for(int i=0; i<6; i++)
				{
					y[i] -= 800;
					btnRobot[i].setLocation(x[i], y[i]);
				}
			}
			else {
				for (int i = 0; i < 6; i++) {
					y[i] += 5;

					btnRobot[i].setLocation(x[i], y[i]);
				}
			}
		}
		else if(key == 32) // jump
		{
			for(int i=0; i<=20; i++)
			{
				for(int j=0; j<6; j++)
				{
					// x = x0 + vx* t
					int newX = x[j] + (i*5);
					// y = y0 + vy*t - 0.5*g*t^2
					// 위식은 좌표계의 좌측하단이 (0,0)인것을 가정하고 만든 식이란 걸 명심
					// 실제 적용할때 좌표 변환 필요
					int newY = 800 - (int) ((800-y[j]) + (50*i) - (0.5*5*i*i));
					
					if(newX >= 1000)
					{
						newX -= 1000;
					}
				
					btnRobot[j].setLocation(newX, newY);
				}
			
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(key == 88) // robot arm shooting
		{
			btnRobot[3].setSize(btnRobot[3].getHeight(), btnRobot[3].getWidth());
			for(int i=0; i<=20; i++)
			{
				btnRobot[3].setLocation(btnRobot[3].getX() + 3, y[3]);
				try {
					Thread.sleep(7);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			for(int i=0; i<=20; i++)
			{
				btnRobot[3].setLocation(btnRobot[3].getX() - 3, y[3]);
				try {
					Thread.sleep(7);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			btnRobot[3].setSize(btnRobot[3].getHeight(), btnRobot[3].getWidth());
		}
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
