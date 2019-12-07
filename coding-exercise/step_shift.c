/*
* 정수 배열과 정수 k가 주어지면 모든 원소를 k칸씩 앞으로 옮기시오.
* 시간복잡도를 최대한 최적화 하시오.
*/

void rotate(int* arr, int k, int len)
{	
	int* tmp_arr = new int[len];
	k %= len;
	for (int i = 0; i < len; i++)
	{
		if (i < len - k)
		{
			tmp_arr[i + k] = arr[i];
		}
		else
		{
			tmp_arr[i - len + k] = arr[i];
		}
	}

	for (int i = 0; i < len; i++)
	{
		arr[i] = tmp_arr[i];
	}
	delete[] tmp_arr;
	
}


void print(int* arr, int len)
{
	for (int i = 0; i < len; i++)
	{
		printf("%3d ", arr[i]);
	}
}

int main()
{
	int arr[5] = { 1, 2, 3, 4, 5 };
	int k = -1; // shift step
	int len = sizeof(arr) / sizeof(int);

	print(arr, len);
	printf(", k=: ");
	scanf("%d", &k);

	rotate(arr, k, len);
	print(arr, len);
	printf("\n");

	return 0;
}