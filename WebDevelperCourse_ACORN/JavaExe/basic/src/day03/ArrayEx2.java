package day03;

// 배열 : 같은 타입의 데이터를 하나의 이름으로
// 묶어서 처리해주는 기능
// 참조형 변수 : 주소(참조값)을 가지고 있다
// 배열의 인덱스를 사용해서 배열의 각 요소에  접근 가능
// 인덱스의 번호는 0번 부터 시작한다

// 배열과 일반 변수와의 구분 [] 여부
// 자료형[] 변수명;
// 자료형 변수명[];

// 배열을 선언만 하면 메모리에 생성은 되지만
// 값을 담을 수 있는 요소가 만들어지지 않는다
// new라는 연산자에 의해서 배열 요소가 생성되어진다.

public class ArrayEx2 {
	public static void main(String[] args) {
		
//		  int[] k = new int[3]; 
//		  for(int i=0; i<k.length; i++) 
//		  { 
//			  k[i] = (k.length - i) * 10;
//			  //System.out.println(k[i]);
//		  }
//		  System.out.println(k[1]);
		
		int[] d = {41, 29, 36};
		int idx = 0;
		for(int elem : d)
		{
			idx++;
			if(idx == 2)
				System.out.println(elem);
		}
	}
}
