package day09;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Color;


public class MyWinEx3 extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Button btnRed, btnBlue;
	
	MyWinEx3()
	{
		super("신호등 버튼");
		//setTitle("신호등 버튼");
		setSize(400,400);
		setLocation(100,100);
		setVisible(true);
		
		btnRed = new Button("RED");
		btnBlue = new Button("BLUE");
		
//		add(btnBlue,"East");
//		add(btnRed,"West");
		
		// 배치관리자를 사용하지 않고 커스텀하게 지정
		// 모든 컴포넌트는 크기와 위치를 직접 지정해야 한다.
		
		//btnRed.addActionListener(인터페이스 참조변수 => 인터헤이스를 구현한 객체);
		Handler hd = new Handler();
		btnRed.addActionListener(hd);
		btnBlue.addActionListener(hd);
		
		setLayout(null); // 기본 배치관리자 disable
		
		btnRed.setSize(50,50);
		btnRed.setLocation(30, 300);
		btnBlue.setSize(50,50);
		btnBlue.setLocation(320,300);
		
		// 컴포넌트의 배경색
		btnBlue.setBackground(Color.blue);
		btnRed.setBackground(Color.red);
		
		add(btnBlue);
		add(btnRed);
	}
	
	public static void main(String[] args) {
		MyWinEx3 mw3 = new MyWinEx3();
	}// main method end
	
	// 일반적으로 1개의 java파일에 클래스는 1개만 사용 원칙
	// public class가 아니라면 여러개 정의 가능 but 잘 하지 않음
	class Handler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			//String name = e.getActionCommand();
			Object obj = e.getSource();
			System.out.println(obj);
			
			if(obj == btnRed)
			{
				System.out.println("빨간버튼 눌림");
			}
			else if(obj == btnBlue)
			{
				System.out.println("파란버튼 눌림");
			}
			
//			if(name.equalsIgnoreCase("RED"))
//			{
//				System.out.println("빨간버튼 눌림");
//			}
//			else if(name.equalsIgnoreCase("BLUE"))
//			{
//				System.out.println("파란버튼 눌림");
//			}		
		}
	}
	
}// class end


