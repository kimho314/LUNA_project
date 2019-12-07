package day09;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWinEx5 extends Frame implements WindowListener{
	
	
	MyWinEx5()
	{
		// 핸들러 객체를 따로 생성하지 말고
		// 내 클래스에서 핸들러 객체의 역할을 할 수 있도록 할 수 있따.
		this.addWindowListener(this);
		
		setSize(800,600);
		setLocation(100,100);
		setVisible(true);
	}
	
	

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("활성화 상태일 때 호출");
	}




	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("종료된 후에 호출");
	}




	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("종료 중일때 호출");
		
		// 0 : 정상종료
		// 0이 아닌 다른 값 : 비정상 종료
		System.exit(0);
	}




	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("비활성화 상태일때 호출");
	}




	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("아이콘에서 원상태로 돌아올때 호출");
	}




	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("아이콘 상태일때 호출");
	}




	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("윈도우창 열릴때 호출");
		
	}
	
	
	
	public static void main(String[] args) {
		MyWinEx5 mw5 = new MyWinEx5();
	}
}
