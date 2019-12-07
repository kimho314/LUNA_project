package day08;

public class Police {
	String name;
	String position;
	int age;	
	Weapon w;
	
	Police()
	{
		name = "포돌이";
		position = "순경";
		age = 20;
	}
	
	Police(Weapon w)
	{
		name = "포돌이";
		position = "순경";
		age = 20;
		this.w = w;
	}

	public Weapon getW() {
		return w;
	}

	public void setW(Weapon w) {
		this.w = w;
	}

	public void patrol()
	{
		System.out.println("순찰중");
	}
	
	public void eatDobut()
	{
		System.out.println("도넛 먹는중");
	}
	
	public void attack()
	{
		//System.out.println("공격하고 있습니다.");
		if(w != null)
			w.fire();
		else
			System.out.println("무기없어 도리도리...");
	}
	
	public void arrest()
	{
		System.out.println("당신을 체포합니다.");
	}
}
