package test1;

public class Derived extends Base{
	String s;
	
	public Derived()
	{
		s = "Dervied";
	}
	
	public void what()
	{
		System.out.println("This is " + s);
	}
}
