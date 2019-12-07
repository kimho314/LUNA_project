package day10;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

// 외부에 클래스를 정의했기 때문에 다른 곳에서 같은 이름의
// 클래스를 못 만들게 된다
// 이때 익명 클래스를 사용하면 된다.
//class Test extends WindowAdapter
//{
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.exit(0);
//	}
//}

public class MyWin extends Frame {
	
	MyWin()
	{
		//WindowAdapter wa = new Test();
//		WindowAdapter wa = new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.out.println("종료합니다.");
//				System.exit(0);
//			}
//		}; // -> 익명클래스
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다.");
				System.exit(0);
			}
		});
		
		setBounds(100,100,600,400);
		setVisible(true);
	}

	
	
	
	public static void main(String[] args) {
		MyWin sw = new MyWin();
	}
}
