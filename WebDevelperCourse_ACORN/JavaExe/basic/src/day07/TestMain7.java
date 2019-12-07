package day07;

public class TestMain7 {
	public static void main(String[] args) {
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		
		c.setRadius(10);
		System.out.println("radius : " + c.getRadius());
		System.out.println("Area : " + c.getCalArea());
		
		r.setHeight(3);
		r.setWidth(4);
		System.out.println("height : " + r.getHeight() + " width : " + r.getWidth());
		System.out.println("Area : " + r.getCalArea());
		
		t.setHeight(5);
		t.setWidth(8);
		System.out.println("height : " + t.getHeight() + " width : " + t.getWidth());
		System.out.println("Area : " + t.getCalArea());
	}
}
