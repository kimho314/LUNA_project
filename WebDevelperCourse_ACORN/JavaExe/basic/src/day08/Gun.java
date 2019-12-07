package day08;

public class Gun implements Weapon{
	int bullet;
	
	Gun()
	{
		bullet = 6;
	}
	
	@Override
	public void fire()
	{
		if(bullet > 0)
		{
			System.out.println("?~~~?~~~~");
			bullet--;
		}
		else
		{
			System.out.println("??? ??????.!!!!");
			bullet = 0;
		}
	}
	
	@Override
	public void reload()
	{
		System.out.println("????...");
		bullet = 6;
	}
}
