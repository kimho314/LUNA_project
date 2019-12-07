package day07;

public class Whale extends Mammal implements Flyable{
	
	Whale()
	{
		species = "Èò¼ö¿°°í·¡";
		tail = 1;
		head = 1;
		color = "È¸»ö";
		age = 5;
	}
	
	@Override
	public void eating()
	{
		System.out.println("»õ¿ì¸¦ ¸Ô¾î¿ä");
	}
	
	@Override
	public void sleeping()
	{
		System.out.println("Àú ¹Ù´Ù¿¡ ´©¿ö ÄðÄð");
	}
	
	public void swimming()
	{
		System.out.println("¿È~~ÆÄ ¿È~~~ÆÄ");
	}
	
	@Override
	public void fly()
	{
		System.out.println("³ª´Â °í·¡~~~");
	}
}
