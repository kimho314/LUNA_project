package day08;

// java.lang -> 자바 코어에 있는 패키지라 따로 import안해줘도 된다
// import java.lang.*; -> 생락 가능
public class TestMain {
	public static void main(String[] args) {
		
		System.out.println(StaticEx2.b);
		
		StaticEx2 se = new StaticEx2();
		System.out.println(se.a);
	}
}
