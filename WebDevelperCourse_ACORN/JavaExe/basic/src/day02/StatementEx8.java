package day02;

public class StatementEx8 {
	public static void main(String[] args) {
		int kor = 80;
		int eng = 70;
		int mat = 20;
		
		// 총점
		// 평균
		int sum = 0;
		double avg = 0.0;
		sum += kor;
		sum += eng;
		sum += mat;
		avg = sum / 3.0;
		System.out.println("sum = " + sum + " avg = " + avg);
		
		// 평균 60점 이상이면 합격, 아니면 불합격
		// 상황에 따라 서로다른 문장을 실행
		// if(condition){
		// 	statement;
		// }
		// else if(condition){
		//	statement;
		// }
		// else{
		//  statement;
		// }
		if(avg >= 60.0)
		{
			System.out.println("당신은 합격입니다.");
		}
		else
		{
			System.out.println("당신은 불합격입니다.");
		}
	}
}
