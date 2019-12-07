// QuickSort.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE	1000

int a[SIZE] = { 0 };

void swap(int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

void quickSort(int start, int end)
{
	if (start >= end)
		return;

	int key = start, i = start + 1, j = end;

	while (i <= j)
	{
		while (i <= end && a[i] <= a[key])
		{
			i++;
		}
		while (j > start && a[j] >= a[key])
		{
			j--;
		}
		if (i > j)
			swap(&a[key], &a[j]);
		else
			swap(&a[i], &a[j]);
	}
	quickSort(start, j - 1);
	quickSort(j + 1, end);
}

int main()
{
	int n = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);
	quickSort(0, n - 1);
	for (int i = 0; i < n; i++)
		printf("%d ", a[i]);
	

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
