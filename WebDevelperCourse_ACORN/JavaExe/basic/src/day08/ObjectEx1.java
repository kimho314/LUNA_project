package day08;

// 자바에서 생락 가능한 것들
// 1. import java.lang.*;
// extends Object
// default constructor
// this : 생성자에서 맴버변수를 가리키는 키워드
// super();
// access modifier default
public class ObjectEx1 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		
		System.out.println(obj1);
		System.out.println(obj1.toString());
		
		// obj1의 실행중인 클래스 객체
		String className = obj1.getClass().getName();
		System.out.println(className);
		
		// object의 클래스명 + @ + 해쉬값을 16진수로 변환한값
		System.out.println(obj1.hashCode());
		System.out.println(Integer.toHexString(obj1.hashCode()));
		System.out.println("-------------------------------");
		
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		System.out.println("obj2 : " + obj2);
		System.out.println("obj3 : " + obj3);
		
		obj2 = obj3;
		
		if(obj2.equals(obj3))
			System.out.println("같은 객체");
		else
			System.out.println("다른 객체");
		System.out.println("-------------------------------");
		
		
		
	}
}
