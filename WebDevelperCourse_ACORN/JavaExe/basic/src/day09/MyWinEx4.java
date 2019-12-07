package day09;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.WindowListener;

public class MyWinEx4 extends Frame 
		implements WindowListener, ActionListener{
	Button btn;
	
	MyWinEx4()
	{
		setTitle("구구단");
		setSize(500,300);
		setLocation(150,150);
		setVisible(true);
		
		btn = new Button("구구단 출력");
		
		setLayout(null);
		btn.setSize(150,60);
		btn.setLocation(175, 200);
		btn.setBackground(Color.cyan);
		
		add(btn);
		
//		Handler2 hd2 = new Handler2();
//		btn.addActionListener(hd2);
		btn.addActionListener(this);
		
		addWindowListener(this);
	}
		
	
	
	public static void main(String[] args) {
		MyWinEx4 mw4 = new MyWinEx4();
	}
	
//	class Handler2 implements ActionListener{
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			for(int i=2; i<=9; i++)
//			{
//				for(int j=1; j<=9; j++)
//				{
//					System.out.print(i + " * " + i + " = " + (i*j) + "  ");
//				}
//				System.out.println("");
//			}
//		}
//	}

	@Override
	public void windowActivated(WindowEvent e) {}


	@Override
	public void windowClosed(WindowEvent e) {}


	@Override
	public void windowDeactivated(WindowEvent e) {}


	@Override
	public void windowDeiconified(WindowEvent e) {}


	@Override
	public void windowIconified(WindowEvent e) {}


	@Override
	public void windowOpened(WindowEvent e) {}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("종료중...");
		System.exit(0);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=2; i<=9; i++)
		{
			for(int j=1; j<=9; j++)
			{
				System.out.print(i + " * " + i + " = " + (i*j) + "  ");
			}
			System.out.println("");
		}
		
	}
}
