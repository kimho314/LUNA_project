package day04;

public class MethodEx4 {
	static int arrSum(int[] a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	static float arrAvg(int[] a) {
		float avg = (float)arrSum(a) / (float)a.length;
		return avg;
	}
	
	public static void main(String[] args) {
		int[] m = {10,20,30,40};
		
		System.out.println("메인 메서드에서 m :" + m);
		
		// 배열의 합계 : 100
		// 배열의 평균 : 250.0
		int ret1 = arrSum(m);
		float ret2 = arrAvg(m);
		System.out.println("배열의 합계 : " + ret1);
		System.out.println("배열의 평균 : " + ret2);
	}
}
