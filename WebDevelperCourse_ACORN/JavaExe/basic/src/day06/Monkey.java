package day06;

public class Monkey {
	private int m_bananas;
	
	Monkey()
	{
		m_bananas = 0;
	}
	
	Monkey(int bananas)
	{
		m_bananas = bananas;
	}
	
	Monkey(Monkey m)
	{
		m_bananas = m.m_bananas;
	}
	
	public int getBananas()
	{
		return m_bananas;
	}
	
	public void setBananas(int bananas)
	{
		m_bananas += bananas;
	}
	
	public void eatBanana(int banana)
	{
		setBananas(banana);
		System.out.println("eating " + getBananas() + " banana~~~");
	}
	
	public static void main(String[] args) {
		Monkey mk = new Monkey();
		mk.eatBanana(1);
	}
}
