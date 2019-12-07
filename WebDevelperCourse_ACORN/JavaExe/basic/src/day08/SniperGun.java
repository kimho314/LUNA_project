package day08;

public class SniperGun implements Weapon {
	int bullet;
	
	SniperGun()
	{
		bullet = 5;
	}
	
	@Override
	public void fire()
	{
		if(bullet > 0)
			System.out.println("스나이핑~~~~");
		else
		{
			System.out.println("총알이 떨어졌습니다.");
			bullet = 0;
		}
	}
	
	@Override
	public void reload()
	{
		System.out.println("재장전중");
		bullet = 5;
	}
}
