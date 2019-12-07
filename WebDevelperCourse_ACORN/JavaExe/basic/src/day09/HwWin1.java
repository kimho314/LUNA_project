package day09;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class HwWin1 extends Frame implements WindowListener{
	Button[] btn;
	
	HwWin1()
	{
		setTitle("HwWin1");
		setSize(800,600);
		setLocation(50,50);

		
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		
		btn = new Button[50];
		for(int i=0; i<50; i++)
		{
			int cnt = i+1;
			btn[i] = new Button(String.valueOf(cnt));
			add(btn[i]);
		}
		setVisible(true);
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		HwWin1 hw1 = new HwWin1();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("종료합니다~~~~");
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {}
}
