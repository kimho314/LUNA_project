#include "common.h"
#include "gameTime.h"
#include "gameContinue.h"
#include "gameMoney.h"

int tot_game_num = 0;
int you_win_num = 0;
int final_win_rate = 0;

void cal_winning_rate(int num_in)
{
	double win_rate = 0;

	tot_game_num++;
	if (num_in == 2)
		you_win_num++;

	assert(tot_game_num > 0);
	win_rate = (double)((double)you_win_num / (double)tot_game_num) * 100.0;
	final_win_rate = (int)win_rate;
	printf("현재 승률은 %3d%%입니다\n\n", final_win_rate);
}

void ShowResult()
{
	int youMoney = 0;
	int comMoney = 0;
	int betMoney = 0;
	int winRate = 0;


	printf("◇◇◇◇◇◇ 최종 결과 ◇◇◇◇◇◇\n");
	printf("최종 승률: %3d%%\n", final_win_rate);

	youMoney = getGamerMoney();
	comMoney = getComMoney();
	winRate = getWinRate();
	setGameSave(comMoney, youMoney, winRate);

	printf("이용해 주셔서 고마워요~\n");
}

void setWinRate(int win_rate)
{
	final_win_rate = win_rate;
}

int getWinRate()
{
	return final_win_rate;
}