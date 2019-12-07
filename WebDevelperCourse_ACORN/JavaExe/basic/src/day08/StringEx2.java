package day08;

public class StringEx2 {
	public static void main(String[] args) {
		String str = "java oracle";
		
		// 4번째 문자(배열의 인덱스)
		System.out.println(str.charAt(3));
		
		String str2= "Monday";
		
		// 문자열 연결
		String str3 = str.concat(" " + str2);
		System.out.println(str3);
		
		String str4 = "Today is".concat(" Friday");
		System.out.println(str4);
		
		// method chaining
		String msg = "Today is".concat(" Friday").concat(" Tomorrow is").concat(" Satuday");
		System.out.println(msg);
		
		System.out.println(str.contains("java"));
		
		// equalsIgnoreCase(); : 대소문자 가리지 않고 비교
		boolean isSame = str.equalsIgnoreCase("JAVA ORACLE");
		System.out.println(isSame);
		
		// 해당 문자의 위치를 리턴
		// (단 배열의 인덱스이므로 0부터...)
		int position = str.indexOf('r');
		System.out.println("r position : " + position);
		
		// 문자열 길이 : length();
		System.out.println(str.length());
		
		// 문자열의 부분집합 : substring();
		// substring(2,6) : 2번부터 6번 전까지 글자
		String str5 = str.substring(2,6);
		System.out.println(str5);
		
		// 문자열을 char배열로 리턴하는 메서드
		char[] ch2 = str.toCharArray();		
		// 배열을 반복 사용해서 화면에 출력
		for(int i=0; i<ch2.length; i++)
		{
			System.out.println(ch2[i]);
		}
		System.out.println("");
		
		int a = 20;
		
		// valueOf 메소드를 통해서 문자열 형 변환
		String value = String.valueOf(a);
		System.out.println(value);
		
		
		// id + @ + domain: id만 추출
		String email = "dagda@hanafos.com";
		System.out.println(email.substring(0,5));
		System.out.println(email.substring(0,email.indexOf("@")));
		
		System.out.println(str.toString());
	}
}
