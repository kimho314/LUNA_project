package day07;

public class Ghost extends Terran {
	int offense;
	int nuclearBomb;
	
	Ghost()
	{
		super();
		offense = 4;
		nuclearBomb = 0;
	}
	
	public void fire()
	{
		if(nuclearBomb >= 1)
			System.out.println("nuclear detected~~~");
		else
			System.out.println("No nuclear bomb~~~~");
	}
}
