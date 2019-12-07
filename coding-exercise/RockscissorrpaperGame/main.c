#include "common.h"
#include "game.h"
#include "gameTime.h"
#include "gameMoney.h"
#include "gameContinue.h"

int main()
{
	int com = 0;
	int you = 0;
	int ret = -1;
	

	ret = setGameContinue();
	
	if (ret == 0)
	{
		puts("자! 게임을 시작합니다.");
		puts("");
		InitGamerMoney();
		printf("\n");
	}

	while (1)
	{
		UpdateBetMoney();
		puts("☆☆☆☆☆☆ 대결! ☆☆☆☆☆☆!!");
		com = ChoiceOfCom();
		you = ChoiceOfMe();
		if (you == 4)
		{			
			ShowResult();
			break;
		}
		puts("");


		puts("☆☆☆☆☆☆ 결과! ☆☆☆☆☆☆!!");
		ret = WhoIsWinner(com, you);

		if (com == SCISSOR)
			puts("> 컴퓨터의 선택은 가위. ");
		else if (com == ROCK)
			puts("> 컴퓨터의 선택은 바위. ");
		else
			puts("> 컴퓨터의 선택은 보");

		if (you == SCISSOR)
			puts("> 당신의 선택은 가위. ");
		else if (you == ROCK)
			puts("> 당신의 선택은 바위. ");
		else
			puts("> 당신의 선택은 보");

		puts("");
		cal_winning_rate(ret);
		ret = UpdateMoney(ret);
		if (ret == 1 || ret == 2)
		{
			ShowResult();
			break;
		}
		ShowMoney();
		printf("\n");
	}
	

	return 0;
}