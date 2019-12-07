package day07;

public class Rectangle extends Figure{
	private int width;
	private int height;
	
	Rectangle()
	{
		width = 0;
		height = 0;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
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
		return width * height;
	}
	
}
