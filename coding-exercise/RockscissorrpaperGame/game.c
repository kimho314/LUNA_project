#include <time.h>
#include "common.h"
#include "game.h"

int ChoiceOfCom()
{
	int num = 0;

	srand((unsigned int)time(NULL));
	num = rand() % 3 + 1;

	return num;
}

int ChoiceOfMe()
{
	int choice = 0;

	printf("가위<1> 바위<2> 보<3>  종료<4> 선택?  ");
	scanf("%d", &choice);
	assert(choice == 1 || choice == 2 || choice == 3 || choice == 4);
	

	return choice;
}

int WhoIsWinner(int com, int you)
{
	int ret = 0;

	if (com > you)
	{
		puts("컴퓨터의 승리입니다!");
		ret = 1;
	}
	else if (you > com)
	{
		puts("당신의 승리입니다!");
		ret = 2;
	}
	else if ((com == 1) && (you == 3))
	{
		puts("컴퓨터의 승리입니다!");
		ret = 1;
	}
	else if ((com == 3) && (you == 1))
	{
		puts("당신의 승리입니다!");
		ret = 2;
	}
	else
		puts("비겼습니다!");
	
	return ret;
}