package day09;

import java.awt.Frame;

public class MyWinEx1 extends Frame {
	
	MyWinEx1()
	{
		super(); // 부모의 기본생성자를 호출
		// 화면에 보이기 지정
		this.setVisible(true);
		// 창의 크기를 너비 800px, 높이 600px로 지정
		// 화면의 좌측 상단을 (0,0)으로 설정
		this.setSize(800,600);
		// 창을 화면의 좌츨 상단으로부터 (200,100)만큼 이동시킨다
		setLocation(200,100);
		// 창에 타이틀 주기
		setTitle("내가만든 윈도우");
	}
	
	public static void main(String[] args) {
		MyWinEx1 mw1 = new MyWinEx1();
		
		
	}
}
