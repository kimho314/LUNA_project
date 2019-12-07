package day01;

// VarEx4 클래스 시작
public class VarEx4 {
	// main 메소드 시작
	public static void main(String[] args)
	{
		// char타입인 변수 c1에 67 할당
		char c1 = 67;
		// char타입인 변수 c2에 'c'할당
		char c2 = 'c';
		// chat타입인 변수 c3에 'a'를 unicode형식인 '\u0061'을 할당
		char c3 = '\u0061'; // unicode
		
		// 문자열 "c1 : "와 c1에 할당된 'c'을 컴퓨터 화면에 출력
		System.out.println("c1 : " + c1);
		// 문자열 "c2 : "와 c2에 할당된 'c'을 컴퓨터 화면에 출력
		System.out.println("c2 : " + c2);
		// 문자열 "c3 : "와 c3에 할당된 'a'을 컴퓨터 화면에 출력
		System.out.println("c3 : " + c3);
		
		// char탕비인 m1, m2, m3, m4에 각각 'J', 'A', 'V', 'A'을 할당
		char m1 = 'J';
		char m2 = 'A';
		char m3 = 'V';
		char m4 = 'A';
		
		// m1,m2,m3,m4에 할당문 문자 'J', 'A', 'V', 'A'을 화면에 연속해서 출력
		// 단 문자로 출력할려면 맨 앞에 ""을 붙여야만 한다
		System.out.println("" + m1 + m2  + m3 + m4);
		
		// String타입인 변수 str에 문자열 "string"할당
		String str = "string";
		// 컴퓨터 화면에  문자열 "string" 출력
		System.out.println(str);
		System.out.println("---------------");
		// 특수 문자
		// \n : newline
		// \b : backspace
		// \t : tab
		// \\ : \
		// \' : '
		// \" : "
		
		// 화면에
		// today
		//  is funny
		//  wednesday.
		// 을 출력
		System.out.println("today \n is funny \n wendesday.");
		
		
	}
}
