package day03;

// ArrayEx4 클래스 시작
public class ArrayEx4 {
	// main 메소드 시작
	public static void main(String[] args) {
		// int형 3x2 배열 선언
		int[][] b = new int[3][2];
		
		// 배열의 각 요소에 10, 20, 30, 40, 50, 60 할당
		// b[0][0] = 0,  b[0][1] = 10
		// b[1][0] = 20, b[1][1] = 30
		// b[2][0] = 40, b[2][1] = 50
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<2; j++)
			{
				b[i][j] = ((i*2) + (j+1))*10;
				// 배열의 각 요소들을 화면에 출력
				System.out.print(b[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
