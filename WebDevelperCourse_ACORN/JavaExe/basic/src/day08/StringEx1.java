package day08;

public class StringEx1 {
	public static void main(String[] args) {
		String str1 = new String("java");
		String str2 = new String("java");
		
		if(str1 == str2)
			System.out.println("동일 객체");
		else
			System.out.println("다른 객체");
		
		// String의 equals메소드는 문자열이 같은지를 판단한다.
		if(str1.equals(str2))
		{
			System.out.println("동일한 내용");
		}
		else
		{
			System.out.println("다른 내용");
		}
		
		// 주소얻기
		System.out.println(str1.getClass().getName() + "@" + Integer.toHexString(str1.getClass().hashCode()));
		System.out.println("--------------------------");
		
		String str3 = "JAVA";
		String str4 = "JAVA";
		
		if(str3 == str4)
		{
			System.out.println("동일 객체");
		}
		else
		{
			System.out.println("다른 객체");
		}
		
		str4 = "ORACLE";
		if(str3 == str4)
		{
			System.out.println("동일 객체");
		}
		else
		{
			System.out.println("다른 객체");
		}
		
		System.out.println("--------------------------");
		String str = "*";
		// String에  *을 붙일때마다 새로운 메모리를 할당받아서 사용한다.
		// 즉 *을 많이 붙일수록 메모리를 새로 할당받는 횟수가 증가하고 이는 퍼포먼스를 느리게 하는 원인이 된다.
		for(int i=0; i<10; i++)
			str+="*";
		
	}
}
