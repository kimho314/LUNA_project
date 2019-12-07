package day05;

public class Person {
	// member variable(field)
	String m_name;
	int m_age;
	int m_eye;
	int m_norse;
	int m_mouth;
	String m_gender;
	
	// method
	// constructor : 객체의 초기화를 담당한다
	// 클래스명과 동일
	// 리턴타입이 ㅇ벗고 void 키워드도 사용하지 않는다.
	// 아무런 매개변숟 ㅗ없는 생성자 ==> 기본 생성자
	// 따로 지정하지 않으면 JVM이 적어도 기본생성자는 존재하는 것으로 간주
	// 변소의 기본값으로 초기화
	Person()
	{
		m_name = "";
		m_age = 0;
		m_eye = 0;
		m_norse = 0;
		m_mouth = 0;
		m_gender = "";
	}
	
	// constructor overloading
	Person(String name, int age, int eye, int norse, int mouth, String gender)
	{
		m_name = name;
		m_age = age;
		m_eye = eye;
		m_norse = norse;
		m_mouth = mouth;
		m_gender = gender;
	}
	
	void printInfo()
	{
		System.out.println(m_name);
		System.out.println(m_age);
		System.out.println(m_eye);
		System.out.println(m_norse);
		System.out.println(m_mouth);
		System.out.println(m_gender);
	}
	
	void setPInfo(String name, int age, int eye, int norse, int mouth, String gender)
	{
		m_name = name;
		m_age = age;
		m_eye = eye;
		m_norse = norse;
		m_mouth = mouth;
		m_gender = gender;
	}
	
	void eating()
	{
		System.out.println("냠냠냠...");
	}
	
	void talking()
	{
		System.out.println("불라불라");
	}
	
	void thinking()
	{
		System.out.println("나는 생각한다 고로 존재한다.");
	}
	
	public static void main(String[] args) {
		
	}
}
