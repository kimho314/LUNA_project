package day07;

public class Rabbit extends Mammal{
	
	
	Rabbit()
	{
		species = "ÀâÁ¾";
		head = 1;
		tail = 1;
		color = "Èò»ö";
		age = 2;
	}
	
	@Override
	public void eating()
	{
		System.out.println("´ç±ÙÀ» ¸Ô¾î¿ä");
	}
	
	@Override
	public void sleeping()
	{
		System.out.println("ÄğÄğ ÀÚ¿ä");
	}
	
	public void jumping()
	{
		System.out.println("±øÃÑ±øÃÑ");
	}
	 
}
