#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define NUM_K	3
#define LEN		5

typedef struct _point
{
	int x;
	int y;
	int val;
} Point;
Point param_k[NUM_K] = { 0 };
Point prev_param_k[NUM_K] = { 0 };

Point clust[NUM_K][LEN*LEN] = { 0 };

void update_centroid(int **map)
{
	// 그룹별 centroied 업데이트
	for (int i = 0; i < NUM_K; i++)
	{
		int sum_x = 0;
		int sum_y = 0;
		int cnt = 0;
		
		for (int j = 0; j < LEN*LEN; j++)
		{
			if (clust[i][j].val != 0)
			{
				sum_x += clust[i][j].x;
				sum_y += clust[i][j].y;
				cnt++;
			}
		}

		prev_param_k[i] = param_k[i];
		param_k[i].x = (int)((double)sum_x / (double)cnt);
		param_k[i].y = (int)((double)sum_y / (double)cnt);
		param_k[i].val = map[param_k[i].x][param_k[i].y];
	}
}

void clustering(int **map)
{
	double dist[NUM_K][LEN*LEN] = { 0 };

	// clust 초기화
	for (int i = 0; i < NUM_K; i++)
	{
		memset(clust[i], 0, sizeof(clust[i]));
	}
	
	// centroid부터 각 데이터까지의 거리를 계산
	for (int i = 0; i < NUM_K; i++)
	{
		for (int j = 0; j < LEN; j++)
		{
			for (int k = 0; k < LEN; k++)
			{				
				dist[i][j * LEN + k] = pow((double)((double)j - param_k[i].x), 2) + pow((double)((double)k - param_k[i].y), 2);				
			}
		}
	}

	// 한 centroied에 가까운 데이터들끼리 clustering
	for (int i = 0; i < LEN * LEN; i++)
	{
		int min_idx = 0;
		for (int j = 1; j < NUM_K; j++)
		{
			if (dist[min_idx][i] > dist[j][i])
				min_idx = j;
		}
		clust[min_idx][i].x = i / LEN;
		clust[min_idx][i].y = i % LEN;
		clust[min_idx][i].val = map[i / LEN][i % LEN];		
	}
}

void choose_k(int **map)
{
	int cnt = 0;
	/*
	srand((unsigned int)time(NULL));
	for (int i = 0; i < NUM_K; i++)
	{
		param_k[i].val = rand() % (LEN * LEN) + 1;
		if (i >= 1)
		{
			while (1)
			{
				for (int j = 0; j < i; j++)
				{
					if (param_k[i].val == param_k[j].val)
						break;
					cnt++;
				}

				if (cnt == i)
				{
					cnt = 0;
					break;
				}					
				
				cnt = 0;
			}
		}		
	}
	*/
	printf("choose k(%2d): ", NUM_K);
	for (int i = 0; i < NUM_K; i++)
	{
		scanf("%d", &param_k[i].val);
	}

	for (int i = 0; i < NUM_K; i++)
	{
		for (int j = 0; j < LEN; j++)
		{
			for (int k = 0; k < LEN; k++)
			{
				if (param_k[i].val == map[j][k])
				{
					param_k[i].x = j;
					param_k[i].y = k;
				}
			}
		}
	}	
}

void init_map(int** map)
{
	for (int i = 0; i < LEN; i++)
	{
		for (int j = 0; j < LEN; j++)
		{
			map[i][j] = ((i * LEN) + j) + 1;
		}
	}
}

void print_2darray(int** arr)
{
	for (int i = 0; i < LEN; i++)
	{
		for (int j = 0; j < LEN; j++)
		{
			printf("%3d ", arr[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

void print_result()
{
	printf("===result centroid===\n");
	printf("val| %3d %3d\n", param_k[0].val, param_k[1].val);
	printf("x  | %3d %3d\n", param_k[0].x, param_k[1].x);
	printf("y  | %3d %3d\n", param_k[0].y, param_k[1].y);
	printf("\n");

	for (int i = 0; i < NUM_K; i++)
	{
		printf("=== group:%3d === \n", i + 1);
		printf("| val | x | y |\n");
		for (int j = 0; j < LEN * LEN; j++)
		{
			if (clust[i][j].val != 0)
			{
				printf("%4d %4d %4d\n", clust[i][j].val, clust[i][j].x, clust[i][j].y);
			}
		}
		printf("\n");
	}
}

int main()
{
	char ch = 0;
	int cnt_loop = 0;
	int** map = malloc(sizeof(int*) * LEN);
	for (int i = 0; i < LEN; i++)
	{
		map[i] = malloc(sizeof(int) * LEN);
	}
	init_map(map);

	while (1)
	{
		print_2darray(map);
		choose_k(map);
		/*printf("===init centroid===\n");
		printf("val| %3d %3d\n", param_k[0].val, param_k[1].val);
		printf("x  | %3d %3d\n", param_k[0].x, param_k[1].x);
		printf("y  | %3d %3d\n", param_k[0].y, param_k[1].y);
		printf("\n");*/

		while (1)
		{
			clustering(map);
			update_centroid(map);
			cnt_loop++;

			if ((param_k[0].val == prev_param_k[0].val) && (param_k[1].val == prev_param_k[1].val))
				break;
			if (cnt_loop >= 100)
				break;
		}
		print_result();

		getchar();
		printf("quit?(q: quit) ");
		scanf("%c", &ch);
		system("cls");
		if (ch == 'q')
			break;
		
	}

	for (int i = 0; i < LEN; i++)
	{
		free(map[i]);
	}
	free(map);


	return 0;
}
