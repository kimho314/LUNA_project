package day09;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class Login extends Frame implements WindowListener, ActionListener, KeyListener{
	Button btn1, btn2;
	TextField idtf, pwtf;
	Label idlb, pwlb;

	
	Login()
	{
		setTitle("Login");
		setSize(600,400);
		setLocation(150,150);
		setVisible(true);
		
		btn1 = new Button("로그인");
		btn2 = new Button("종료");
		
		setLayout(null);
		btn1.setSize(100, 50);
		btn1.setLocation(150, 300);
		btn2.setSize(100, 50);
		btn2.setLocation(350, 300);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		add(btn1);
		add(btn2);
		
		idtf = new TextField(10);
		pwtf = new TextField(10);
		idtf.setSize(100, 50);
		idtf.setLocation(350, 50);
		pwtf.setSize(100, 50);
		pwtf.setLocation(350, 150);
		
		idtf.addKeyListener(this);
		pwtf.addKeyListener(this);
		pwtf.setEchoChar('*');

		add(idtf);
		add(pwtf);
		
		
		idlb = new Label("ID");
		pwlb = new Label("PW");
		idlb.setSize(100,50);
		pwlb.setSize(100,50);
		idlb.setLocation(200,50);
		pwlb.setLocation(200,150);
		
		
		add(idlb);
		add(pwlb);
		
		addWindowListener(this);
		
	}
	
	public static void main(String[] args) {
		Login lg = new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn1)
		{
			String id = idtf.getText();
			String pw = pwtf.getText();
		
			System.out.println("ID : " + id);
			System.out.println("PW : " + pw);
			
			if(id.contentEquals("khs") && pw.contentEquals("2959"))
			{
				System.out.println("Logining...");
			}
			else
			{
				System.out.println("Login Failed...");
			}
		}
		else if(obj == btn2)
		{
			System.out.println("Exit");
			System.exit(0);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Closing");
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
	public void keyPressed(KeyEvent arg0) {}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyChar() == KeyEvent.VK_ENTER)
		{
			System.out.println("ID : " + idtf.getText());
			System.out.println("PW : " + pwtf.getText());
		}
	}
}
