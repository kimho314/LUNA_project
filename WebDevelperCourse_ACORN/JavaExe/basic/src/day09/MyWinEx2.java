package day09;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWinEx2 extends Frame{
	// 자료형 변수명
	Button btnNorth, btnSouth, btnEast, btnWest, btnCenter;

	
	MyWinEx2()
	{
		setTitle("샘플 윈도우");
		
		// 컴포넌트 초기화
		btnNorth = new Button("North");
		btnSouth = new Button("South");
		btnEast = new Button("East");
		btnWest = new Button("West");
		btnCenter = new Button("Center");
		
		// 컨테이너에 부착 -> 동,서,남,북에 배치
		// 따로 명시하지 않으면 정중앙에 배치
		add(btnNorth,"North");
		add(btnSouth,"South");
		add(btnEast,"East");
		add(btnWest,"West");
		add(btnCenter,"Center");
		
		// 컨테이너에서 컴포넌트 배치하는 방법
		// 1. 배치관리자에 의해 배치
		//		Frame의 기본 배치관리자는 보더 레이아웃
		//		보더레이아웃 ==> FlowLayout으로 변경

		
		//Flowlayout 객체 생성
		//FlowLayout fl = new FlowLayout();
		
		//현재 컨테이너에 배치관리자를 지정 
		//우에서 좌로 추가한 순서대로 배치한다.
		//setLayout(fl);		
		
		Handler1 hd1 = new Handler1();
		btnCenter.addActionListener(hd1);
		btnNorth.addActionListener(hd1);
		btnSouth.addActionListener(hd1);
		btnEast.addActionListener(hd1);
		btnWest.addActionListener(hd1);
		
		setSize(400,400);
		setLocation(300,300);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyWinEx2 mw2 = new MyWinEx2();
	}
}

class Handler1 implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " 버튼 눌림");
	}
}
