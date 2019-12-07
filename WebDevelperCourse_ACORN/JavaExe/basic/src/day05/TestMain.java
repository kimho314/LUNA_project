package day05;

public class TestMain {
	public static void main(String[] args) {
		// 설계도를 가지고 객체 만들기

		// 클래스명 참조변수;
		Person p;
		p = new Person();

		// 객체가 가지고 있는 변수에 값을 할당
		p.m_name = "홍길동";
		p.m_age = 20;
		p.m_eye = 2;
		p.m_norse = 1;
		p.m_mouth = 1;
		p.m_gender = "냠냠";

		System.out.println(p); // day5.Person@306a30c7 : 참조값
		System.out.println("나이 : " + p.m_age);
		System.out.println("이름 : " + p.m_name); 
		System.out.println("눈 : " + p.m_eye); 
		System.out.println("코 : " + p.m_norse); 

		p.eating(); // 냠냠
		p.talking(); // 블라블라
		p.thinking(); // 고로 존재
	}

}