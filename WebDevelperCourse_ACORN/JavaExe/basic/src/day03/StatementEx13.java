package day03;

// break : 가장 가까운 반복문을 탈출
// break label : 라벨이 붙어있는 반복문을 탈출
// continue : 이번만 생략
// continue label : 라벨명이 붙어있는 반복문에서 이버만 생략
public class StatementEx13 {
	public static void main(String[] args) {
		
		outer:
		for(int i=1; i<=4; i++)
		{
			for(int j=1; j<=4; j++)
			{
//				if(i < j)
//					break;
				if(i == j)
					continue outer;
				System.out.println("i: " + i + " , j: " + j);
			}
		}
	}
}
