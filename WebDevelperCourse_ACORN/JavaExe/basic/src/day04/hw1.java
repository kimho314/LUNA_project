package day04;

public class hw1 {
	
	static int[][] arrSum(int[][] a1, int[][] a2) {
		int[][] arrSum = new int[3][3];
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				arrSum[i][j] = a1[i][j] + a2[i][j];
			}
		}
		return arrSum;
	}

	static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 3, 2, 3 }, { 4, 5, 6 }, { 1, 4, 9 } };
		int[][] arr2 = { { 1, 8, 7 }, { 6, 4, 4 }, { 3, 2, 3 } };

		int[][] result = new int[3][3];
		result = arrSum(arr1, arr2);
		printArr(result);
	}
}
