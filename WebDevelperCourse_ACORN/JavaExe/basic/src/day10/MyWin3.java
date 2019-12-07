package day10;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyWin3 extends JFrame implements ActionListener{
	JButton jbtn;
	JTextField jtf;
	JTextArea jta;
	JScrollPane scrollPane;
	
	MyWin3()
	{		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		setLayout(null);
		
		jbtn = new JButton("단");
		jbtn.setBounds(300,30,100,50);
		add(jbtn);
		jbtn.addActionListener(this);
		
		jtf = new JTextField();
		jtf.setBounds(150,30,100,50);
		add(jtf);
		
		jta = new JTextArea();
		Font f = new Font("궁서", Font.BOLD, 30);
		jta.setFont(f);
	
		scrollPane = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0,100,570,250);
		add(scrollPane);
		scrollPane.setVisible(true);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyWin3 my2 = new MyWin3();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int dan = Integer.parseInt(jtf.getText());
		if (dan >= 2 && dan <= 9) {
			for (int i = 1; i <= 9; i++) {
				//System.out.println(dan + " * " + i + " = " + (dan * i));
				jta.append(dan + " * " + i + " = " + (dan * i) + '\n');
				jta.setCaretPosition(jta.getDocument().getLength());
				
			}
		}
		else
		{
			jta.setText("잘못된 입력입니다.");
		}
	}
}
