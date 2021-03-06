// jungol exercise.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//

#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define LEN_MAX	100

typedef struct string_set
{
	char characters[8] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
	int char_values[8][6] = {
		{0,0,0,0,0,0}, //A
		{0,0,1,1,1,1}, //B
		{0,1,0,0,1,1}, //C
		{0,1,1,1,0,0}, //D
		{1,0,0,1,1,0}, //E
		{1,0,1,0,0,1}, //F
		{1,1,0,1,0,1}, //G
		{1,1,1,0,1,0} //H
	};
}str_set;

int match_characters(str_set s, int* vset, char* matched_str, int len);

int main()
{
	str_set str_set1;
	int value_len = 0;
	int final_len = 0;
	int value_set[LEN_MAX] = { 0, };
	int value_set1[LEN_MAX] = { 0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,0,0 };
	int value_set2[LEN_MAX] = { 0,1,1,1,1,1, 0,0,0,0,0,0, 1,1,1,1,1,1, 0,0,0,0,0,0, 1,1,1,1,1,1 };
	int i = 0;
	int err = 0;
	char matched_str[LEN_MAX];

	srand(time(NULL));
	/*
	for (i = 0; i < LEN_MAX; i++)
	{
		value_set[i] = -1;
	}
	*/
	printf("문자의 개수 입력(10이하 숫자만 가능): ");
	scanf("%d", &value_len);
	if (value_len > 10)
	{
		printf("input error!!!\n");
		return -1;
	}
	final_len = value_len * 6;
	
	for (i = 0; i < LEN_MAX; i++)
	{
		if (i >= final_len)
			break;

		value_set[i] = rand() % 2;
	}
	

	
	err = match_characters(str_set1, value_set, matched_str, final_len);
	//err = match_characters(str_set1, value_set1, matched_str, final_len);
	//err = match_characters(str_set1, value_set2, matched_str, final_len);
	printf("err: %3d\n", err);
	
	if (err == -1)
	{
		printf("%s\n", matched_str);
	}
	else
	{
		printf("%d\n", err);
	}
	
    return 0;
}

int match_characters(str_set s, int *vset, char* matched_str, int len)
{
	int itr_len = 0;
	int i = 0, j = 0, k = 0;
	int tmp_arr[LEN_MAX][6];
	int err_point[LEN_MAX][LEN_MAX] = { 0 ,};
	int err = -1;

	itr_len = len / 6;

	
	for (i = 0; i < len; i++)
	{
		printf("%3d", vset[i]);
	}
	printf("\n\n");
	

	for (i = 0; i < itr_len; i++)
	{
		for (j = 0; j < 6; j++)
		{
			tmp_arr[i][j] = vset[(i*(len/itr_len)) + j];			
		}		
	}
	
	
	for (i = 0; i < itr_len; i++)
	{
		for (j = 0; j < 6; j++)
		{
			printf("%d ", tmp_arr[i][j]);
		}
		printf("\n\n");
	}
	
	//find matched character
	for (i = 0; i < itr_len; i++)
	{
		for (j = 0; j < 8; j++)
		{
			for (k = 0; k < 6; k++)
			{
				if (s.char_values[j][k] != tmp_arr[i][k])
				{
					err_point[i][j]++;
				}
			}

			if (err_point[i][j] == 0)
			{
				matched_str[i] = s.characters[j];
				break;
			}
			else
			{
				matched_str[i] = 'X';
			}
		}
		
	}

	printf("before matched_str: \n");
	for (i = 0; i < itr_len; i++)
	{
		printf("%c", matched_str[i]);
	}
	printf("\n\n");

	printf("before err_point: \n");
	for (i = 0; i < itr_len; i++)
	{
		for (j = 0; j < 8; j++)
		{
			printf("%3d", err_point[i][j]);
		}
		printf("\n");
	}
	printf("\n\n");

	//find the cloesest charater
	for (i = 0; i < itr_len; i++)
	{
		if (matched_str[i] == 'X')
		{
			for (j = 0; j < 8; j++)
			{
				if (err_point[i][j] == 1)
				{
					matched_str[i] = s.characters[j];
					err = -1;
					break;
				}
				else
				{
					err = i + 1;
				}
			}			
		}	

		if (err > -1)
			break;
	}

	printf("after matched_str: \n");
	for (i = 0; i < itr_len; i++)
	{
		printf("%c", matched_str[i]);
	}
	printf("\n\n");	
	
	matched_str[itr_len] = '\0';	

	return err;
}