// killing_zurgling.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
	int row;
	int col;
	int count;
}_COORDI;

_COORDI point[40000];

int map[100][100] = { 0 };

int N, M;

int Dy[4] = { -1,1,0,0 };
int Dx[4] = { 0,0,-1,1 };

int bfs(int row, int col)
{
	int i;
	int head, tail;
	int row_t, col_t;
	int max = 0;

	head = 0;
	tail = 0;

	point[tail].row = row;
	point[tail].col = col;
	point[tail].count = 3;
	max = point[tail].count;
	tail++;
	map[row][col] = 0;

	while (1)
	{
		if (head == tail)
			break;

		for (i = 0; i < 4; i++)
		{
			row_t = point[head].row + Dy[i];
			col_t = point[head].col + Dx[i];
			if (row_t >= 0 && row_t < N && col_t >= 0 && col_t < M)
			{
				if (map[row_t][col_t] == 1)
				{
					point[tail].row = row_t;
					point[tail].col = col_t;
					point[tail].count = point[head].count + 1;
					map[row_t][col_t] = 0;
					if (point[tail].count > max)
						max = point[tail].count;
					tail++;
				}
			}
		}
		head++;
	}

	return max;
}

int arr[100][100] = {
	{0,0,1,0,0,0,0},
	{0,0,1,1,0,0,0},
	{0,0,0,1,1,0,0},
	{1,0,1,1,1,1,1},
	{1,1,1,1,0,1,1},
	{0,0,1,1,1,0,0},
	{0,0,1,1,1,0,0},
	{0,0,0,1,0,0,0}
};

void create_map(int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			map[i][j] = rand() % 2;
		}
	}
	
}

int main()
{
	int i, j;
	int row, col;

	memset(point, 0, sizeof(point));
	memset(map, 0, sizeof(map));

	scanf("%d %d", &M, &N);
	for (i = 0; i < N; i++)
	{
		for (j = 0; j < M; j++)
		{			
			//map[i][j] = arr[i][j];
			create_map(N, M);
			printf("%1d", map[i][j]);
		}
		printf("\n");
	}
	scanf("%d %d", &col, &row);

	int res = bfs(row - 1, col - 1);
	int rem = 0;

	for (i = 0; i < N; i++)
	{
		for (j = 0; j < M; j++)
		{
			if (map[i][j] == 1)
				rem++;
		}
	}

	printf("%d\n", res);
	printf("%d\n", rem);

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
