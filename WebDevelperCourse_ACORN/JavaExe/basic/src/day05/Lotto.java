package day05;

// lotto program
public class Lotto {
	static void printArray1D(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	static void swap(int[] arr, int a, int b)
	{
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	static void selectionSort(int[] arr)
	{
		for(int i=1; i<arr.length; i++)
		{
			for(int j=0; j<=i; j++)
			{
				if(arr[i] < arr[j])
				{
					swap(arr, i, j);
				}
			}
		}
	}
	
	static int partition(int[] arr, int start, int end)
	{
		int low = start+1;
		int high = end;
		int pivot = arr[start];
		
		while(low <= high)
		{
			while((low <= end) && (arr[low] < pivot))
			{
				low++;
			}
			while((high>start) && (arr[high] > pivot))
			{
				high--;
			}
			if(low < high)
				swap(arr, low, high);
			System.out.print("low : " + low + " high : " + high + " pivot : " + start + " ==> ");
			printArray1D(arr);
		}
				
		
		swap(arr, start, high);
		System.out.println("===== parition end =====");
		System.out.print("low : " + low + " high : " + high + " pivot : " + high + " ==> ");
		printArray1D(arr);
		System.out.println("========================");
		
		return high;		

	}
	
	static void quickSort(int[] arr, int start, int end)
	{
		if(start < end)
		{
			int p = partition(arr, start, end);
			quickSort(arr, start, p-1);
			quickSort(arr, p+1, end);
		}
	}
	
	static void bubleSort(int[] arr)
	{
		for(int i=arr.length; i>0; i--)
		{
			for(int j=0; j<i-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// 1. 배열을 선언
		int[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
						18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33,
						34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
		
		// pick 6 number from the array m
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {

			int idx = (int) (Math.random() * m.length);
			//System.out.println("idx : " + idx);
			lotto[i] = m[idx];
			
			if(i>0)
			{
				while(true)
				{
					boolean flag = false;
					for(int j=0; j<=(i-1); j++)
					{
						if(lotto[i] == lotto[j])
						{
							flag = true;
							break;
						}
					}
					
					if(flag == true)
					{
						lotto[i] = m[(int) (Math.random() * m.length)];
						continue;
					}
					else
						break;
				}
			}
		}
		
		System.out.println("===== before sort =====");
		printArray1D(lotto);
		
		// print elements of result in order using any sort algorithm
		//selectionSort(lotto);
		quickSort(lotto, 0, lotto.length-1);
		//bubleSort(lotto);
		
		System.out.println("===== after sort =====");
		printArray1D(lotto);
	}	
}
