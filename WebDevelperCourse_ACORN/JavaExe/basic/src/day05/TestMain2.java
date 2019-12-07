package day05;

public class TestMain2 {
	public static void main(String[] args) {

		// Car c;
		// c = new Car();
		
		Car c = new Car();

		c.차종 = "모닝";
		c.제조사 = "기아";
		c.색상 = "검정";
		c.연도 = 2019;
		c.속도 = 30;
		c.핸들 = 1;

		System.out.println("차종 : " + c.차종);
		System.out.println("제조사 : " + c.제조사);
		System.out.println("색상 : " + c.색상);
		System.out.println("연도 : " + c.연도);
		System.out.println("속도 : " + c.속도);
		System.out.println("핸들 : " + c.핸들);

		c.drive();
		c.parking();
		c.speed();

	}
}