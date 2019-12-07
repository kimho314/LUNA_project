package day07;

public class Triangle extends Figure {
	private int width;
	private int height;
	
	Triangle()
	{
		width = 0;
		height = 0;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	@Override
	public int getCalArea()
	{
		double area = (height * width) / 2;
		return (int)area;
	}
}
