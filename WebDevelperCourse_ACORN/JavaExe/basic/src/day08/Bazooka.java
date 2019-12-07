package day08;

public class Bazooka implements Weapon {
	int bullet;
	
	Bazooka()
	{
		bullet = 3;
	}
	
	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(bullet > 0)
			System.out.println("?~~~?~~~");
		else
		{
			System.out.println("?? ????.");
			bullet = 0;
		}
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		System.out.println("????");
		bullet = 3;
	}

}
