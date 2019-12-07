package day09;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class HwWin4 extends Frame implements WindowListener, ActionListener{
	TextField tf;
	Button[] btn; 
	String txt;
	static int txtCnt = 0;
	String[] btnTxt = {"7", "8", "9", "+", "4", "5", "6", "-", "1", 
			"2", "3", "*", "0", "00", "=", "/"};
	
	
	HwWin4()
	{				
		
		setTitle("계산기");
		setSize(600,500);
		setLocation(0,0);
		setVisible(true);
		
		
		addWindowListener(this);
		
		setLayout(null);
		tf = new TextField(20);
		tf.setSize(400,50);
		tf.setLocation(100, 100);
		add(tf);
		
		btn = new Button[16];
		
		for(int i=0; i<btn.length; i++)
		{
			btn[i] = new Button(btnTxt[i]);
			btn[i].setSize(100,50);
			btn[i].setLocation(tf.getLocation().x + ((i%4)*btn[i].getWidth()), (tf.getLocation().y*2) + ((i/4)*btn[i].getHeight()));
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
	}
	
	public static void main(String[] args) {
		HwWin4 hw4 = new HwWin4();
		
	}

	
	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("종료중~~~");
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = e.getActionCommand();
		if(name.equalsIgnoreCase("="))
		{
			System.out.println("계산 결과: ");
			txt = "";
			tf.setText(txt);
		}
		else {
			if (txtCnt == 0) {
				txt = e.getActionCommand();
			} else {
				txt = txt.concat(e.getActionCommand());
			}
			System.out.println(txt);
			tf.setText(txt);
		}
		txtCnt++;
		if (txtCnt < 0)
			txtCnt = 0;
	}
}
