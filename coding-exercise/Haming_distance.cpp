// Haming_distance.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

void cheeck_dup(int **arr_in, int height, int width)
{
	int cmp_num = 0;
	int i = 1;

	while (1)
	{
		for (int j = 0; j < height; j++)
		{
			cmp_num = 0;
			if (j != i)
			{
				for (int k = 0; k < width; k++)
				{
					if (arr_in[i][k] == arr_in[j][k])
						cmp_num++;
				}

				if (cmp_num > 0)
				{
					for (int k = 0; k < width; k++)
					{
						arr_in[i][k] = rand() % 2;
					}
					continue;
				}
			}
		}

		i++;
		if (i >= height)
			break;
	}
}

void create_bincode(int **arr_in, int n, int k)
{
	srand((unsigned int)time(NULL));
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < k; j++)
		{
			arr_in[i][j] = rand() % 2;
		}
	}
	
}

int haming(int *a, int *b, int width) 
{	
	int num1 = 0, num2 = 0;
	for (int i = 0; i < width; i++)
	{		
		num1 += a[i] << (width - i - 1);
		num2 += b[i] << (width - i - 1);
	}

	int k = num1 ^ num2;
	return !(k&(k - 1));
}

int main(void)
{
	int **arr = NULL;
	int k = 0, n = 0;
	int a = 1, b = 2;
	int ret = 0;
	int idx = 0;
	int dist[1024] = { 0 };
	int cnt = 0;
	int err = 0;

	scanf("%d %d", &n, &k);
	if ((n < 3 && n > 1000) && (k < 2 && k > 30))
	{
		printf("input error!!!\n");
		exit(0);
	}

	arr = (int**)malloc(sizeof(int*)*n);
	for (int i = 0; i < n; i++)
	{
		arr[i] = (int*)malloc(sizeof(int)*k);
	}


	create_bincode(arr, n, k);
	cheeck_dup(arr, n, k);
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < k; j++)
		{
			printf("%d", arr[i][j]);
		}
		printf("\n");
	}
	printf("%d %d\n\n", a, b);

	ret = haming(arr[a-1], arr[b-1], k);


	if (ret == 1)
	{
		printf("%d %d\n", a, b);
	}
	else
	{
		idx = a-1;
		dist[cnt] = idx + 1;
		while (1) 
		{			
			for (int i = 0; i < n; i++)
			{
				ret = haming(arr[idx], arr[i], k);
				if (ret == 1 && i != idx && i != (a-1))
				{
					idx = i;
					cnt++;
					dist[cnt] = idx + 1;					
					break;
				}
				else
				{
					err = -1;
				}
			}

			if (err == -1)
			{
				printf("-1");
				break;
			}

			if (idx == (b - 1))
			{
				for (int i = 0; i < cnt; i++)
				{
					printf("%d ", dist[i]);
				}
				break;
			}
		}
		printf("\n");
	}

	for (int i = 0; i < n; i++)
	{
		free(arr[i]);
	}
	free(arr);

	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
