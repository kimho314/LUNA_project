// Bishop.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

void createBoard(int (*board_in)[10], int N)
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			board_in[i][j] = rand() % 2;
		}
	}
}

void printBoard(int (*board_in)[10], int N)
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			printf("%d ", board_in[i][j]);
		}
		printf("\n");
	}
}

void checkBishop(int(*board_in)[10], int N)
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (board_in[i][j] == 1)
			{
				for (int k = 1; k < N; k++)
				{
					if((i+k) >= 0 && (i + k) < N && (j+k) >=0 && (j + k) < N)
						board_in[i + k][j + k] = 0;
					if ((i + k) >= 0 && (i + k) < N && (j - k) >= 0 && (j - k) < N)
						board_in[i + k][j - k] = 0;
				}
			}
		}
	}
}

int remainBishop(int(*board_in)[10], int N)
{
	int cnt = 0;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (board_in[i][j] == 1)
				cnt++;
		}
	}

	return cnt;
}

int main()
{
	int N = 0;
	int board[10][10] = { 0 };
	int cnt = 0;
	scanf("%d", &N);
	assert(N >= 1 && N <= 10);

	createBoard(board, N);
	printBoard(board, N);
	checkBishop(board, N);
	//printBoard(board, N);
	cnt = remainBishop(board, N);
	printf("%d\n", cnt);

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
