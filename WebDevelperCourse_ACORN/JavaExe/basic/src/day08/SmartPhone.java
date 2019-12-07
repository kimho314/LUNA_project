package day08;

public class SmartPhone {
	String productNmae, phoneNumber;
	static String company;
	int price;
	
	static
	{
		SmartPhone.company = "nono";
	}
	
	// 매개변수 있는 생성자
	public SmartPhone(String productNmae, String phoneNumber, String company, int price) {
		super();
		this.productNmae = productNmae;
		this.phoneNumber = phoneNumber;
		//this.company = company;
		this.price = price;
	}
	
	public static void setCompany(String company)
	{
		SmartPhone.company = company;
	}
	
	// 수신, 발신, 게임하기
	public void receive()
	{
		System.out.println("수신중");
	}	
	

	public void send(String number)
	{
		System.out.println(number + " 발신중");
	}
	
	public static void playGame()
	{
		System.out.println("게임중");
	}
}
