package day10;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWin2 extends JFrame{
	JButton jbtn;
	
	MyWin2()
	{
		ImageIcon icon = new ImageIcon("src/images/cpp.jpg");
		jbtn = new JButton(icon);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		setLayout(null);
	
		jbtn.setSize(300,150);
		jbtn.setLocation(50,50);
		add(jbtn);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyWin2 my2 = new MyWin2();
	}
}
