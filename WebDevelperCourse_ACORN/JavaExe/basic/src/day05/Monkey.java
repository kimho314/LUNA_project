package day05;

public class Monkey {
	int m_eye;
	int m_norse;
	int m_mouth;
	int m_tail;
	String m_species;
	
	Monkey()
	{
		m_eye = 2;
		m_norse = 1;
		m_mouth = 1;
		m_tail = 1;
		m_species = "spider moneky";
	}
	
	Monkey(String species)
	{
		this();
		m_species = species;
	}
	
	void printMonInfo()
	{
		System.out.println("eye : " + m_eye);
		System.out.println("norse : " + m_norse);
		System.out.println("mouth : " + m_mouth);
		System.out.println("tail : " + m_tail);
		System.out.println("species : " + m_species);
	}
	
	void throwAction()
	{
		System.out.println("Throwing!!!");
	}
	
	void eatingAction()
	{
		System.out.println("Eating!!!");
	}
	
	void climbingTree()
	{
		System.out.println("Climbing Tree!!!");
	}
}
