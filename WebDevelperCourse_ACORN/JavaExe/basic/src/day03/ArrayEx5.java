package day03;

// ArayEx5 클래스 시작
public class ArrayEx5 {
	// main 메소드 시작
	public static void main(String[] args) {
		// 크기가 4x3인 int형 배열 선언 및 값 할당
		// m[0][0] = 2, m[0][1] = 1, m[0][2] = 7
		// m[1][0] = 4, m[1][1] = 1, m[1][2] = 3
		// m[2][0] = 2, m[2][1] = 6, m[2][2] = 9
		// m[3][0] = 4, m[3][1] = 7, m[3][2] = 1
		int[][] m = {{2,1,7}, {4,1,3}, {2,6,9}, {4, 7, 1}};
		
		// 배열 m의 행의 길이와 열의 길이를 출력
		System.out.println("lenght : " + m.length + " " + m[0].length);
		// 배열 m의 각 요소들을 화면에 출력
		for(int i=0; i<m.length; i++)
		{
			for(int j=0; j<m[i].length; j++)
			{
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
