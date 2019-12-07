package day08;

public class StaticEx1 {
	// public : 어디에서든 접근 가능
	// static : 인스턴스 생성없이 접근 가능 
	// void : 리턴값이 없음
	// main : method 이름
	// (String[] args) : args라는 이름을 갖는 String타입의 매개변수

	public static void main(String[] args) {
		SmartPhone.company = "화웨이";
		System.out.println(SmartPhone.company);
		SmartPhone.playGame();
		
		SmartPhone.setCompany("Samsung");
		System.out.println(SmartPhone.company);
		
//		SmartPhone sp1 = new SmartPhone("갤럭시노트10", "010-1234-5678", "Samsung", 1248500);
//		SmartPhone sp2 = new SmartPhone("갤럭시폴드", "010-1111-2222", "Samsung", 2398000);
//		
//		sp1.send("010-2222-3333");
//		
//		System.out.println("제조회사 : " + sp1.company);
//		System.out.println("제조회사 : " + sp2.company);
//		
//		sp1.company = "LG";
//		System.out.println("제조회사 : " + sp1.company);
//		System.out.println("제조회사 : " + sp2.company);
	}
}
