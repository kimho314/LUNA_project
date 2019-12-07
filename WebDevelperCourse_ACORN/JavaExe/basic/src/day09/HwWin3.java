package day09;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class HwWin3 extends Frame implements WindowListener, ActionListener{
	Button printBtn, exitBtn;
	Label danLb;
	TextField danTf;
	
	HwWin3()
	{
		setTitle("구구단 출력");
		setSize(400,400);
		//setLocation(100,100);
		setVisible(true);
		
		
		setLayout(null);
		printBtn = new Button("출력");
		exitBtn = new Button("종료");
		printBtn.setSize(100,50);
		exitBtn.setSize(100,50);
		printBtn.setLocation(50,300);
		exitBtn.setLocation(250,300);
		add(exitBtn);
		add(printBtn);
		
		danLb = new Label("단");
		danLb.setSize(100,50);
		danLb.setLocation(94 , 122);
		add(danLb);
		
		danTf = new TextField(5);
		danTf.setSize(100,50);
		danTf.setLocation(250 , 122);
		add(danTf);
		
		printBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		HwWin3 hw3 = new HwWin3();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Closing");
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object obj = arg0.getSource();
		
		if (obj == printBtn) {
			int dan = Integer.parseInt(danTf.getText());
			if (dan > 1 && dan < 10) {
				for (int i = 1; i <= 9; i++) {
					System.out.println(dan + " * " + i + " = " + (dan * i));
				}
			}
			else
				System.out.println("단을 다시 입력하세요.");
		}
		else if(obj == exitBtn) {
			System.out.println("종료중~~~");
			System.exit(0);
		}
	}
}
