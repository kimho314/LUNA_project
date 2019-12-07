package day07;

public class Dog extends Mammal{
	String name;
	
	Dog()
	{
		species = "Çªµé";
		head = 1;
		tail = 1;
		color = "Èò»ö";
		name = "±è°úÀå";
		age = 3;
	}
	
	@Override
	public void eating()
	{
		System.out.println("»ç·á¸¦ ¸Ô¾î¿ä");
	}
	
	@Override
	public void sleeping()
	{
		System.out.println("ÄğÄğ ÀÚ¿ä");
	}
	
	public void running()
	{
		System.out.println("¸¶±¸¸¶±¸ ´Ş·Á¿ä");
	}
}
