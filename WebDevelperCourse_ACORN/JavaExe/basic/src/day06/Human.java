package day06;

public class Human {
	String m_name;
	int m_age;
	String m_gender;
	String m_phoneNum;
	String m_job;
	
	Human()
	{
		m_name = "ȫ�浿";
		m_age = 20;
		m_gender = "man";
		m_phoneNum = "010-1234-5678";
		m_job = "thief";
	}
	
	/**
	 * @param m_name
	 * @param m_age
	 * @param m_gender
	 * @param m_phoneNum
	 * @param m_job
	 */
	Human(String m_name, int m_age, String m_gender, String m_phoneNum, String m_job) {
		super();
		this.m_name = m_name;
		this.m_age = m_age;
		this.m_gender = m_gender;
		this.m_phoneNum = m_phoneNum;
		this.m_job = m_job;
	}
	

	Human(Human m)
	{
		m_name = m.m_name;
		m_age = m.m_age;
		m_gender = m.m_gender;
		m_phoneNum = m.m_phoneNum;
		m_job = m.m_job;
	}
	
	void eating()
	{
		System.out.println(m_name + " is eating~~~");
	}
	
	void speaking()
	{
		System.out.println(m_name + " is speaking~~~");
	}
	
	void breathing()
	{
		System.out.println(m_name + " is breathing~~~");
	}
	
	void status()
	{
		System.out.println("=== view status ===");
		System.out.println("name : " + m_name);
		System.out.println("age : " + m_age);
		System.out.println("gender : " + m_gender);
		System.out.println("phoneNum : " + m_phoneNum);
		System.out.println("job : " + m_job);
	}
}
