package day10;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SampleWindow extends Frame{
	
	SampleWindow()
	{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다");
				System.exit(0);
			}
		});
		setBounds(100,100,600,400);
		setVisible(true);
	}

	
	
	
	public static void main(String[] args) {
		SampleWindow sw = new SampleWindow();
	}
}
