package day07;

public class Circle extends Figure{
	private int r;
	
	Circle()
	{
		r = 0;
	}
	
	public void setRadius(int r)
	{
		this.r = r;
	}
	
	public int getRadius()
	{
		return r;
	}
	
	@Override
	public int getCalArea()
	{
		double area = 3.14 * r * r;
		return (int)area;
	}
}
