package day10;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MeMo extends Frame{
	TextArea ta;
	
	
	MeMo()
	{
		ta = new TextArea();
		Font f = new Font("궁서", Font.BOLD, 35);
		ta.setFont(f);
		add(ta);
		
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
		MeMo sw = new MeMo();
	}
}
