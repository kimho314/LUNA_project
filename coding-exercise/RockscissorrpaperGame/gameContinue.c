#include "common.h"
#include "gameContinue.h"
#include "gameMoney.h"
#include "gameTime.h"

int setGameContinue()
{
	int youMoney = 0;
	int comMoney = 0;
	int betMoney = 0;
	int winRate = 0;
	char tmpBuf[1024] = { '\0' };
	static int cnt = 0;
	int choice = 0;
	int len = 0;
	
		
	printf("게임을 이어서 하시겠습니까? (Yes 1, No 0): ");
	scanf("%d", &choice);
	assert(choice == 1 || choice == 0);
	if (choice == 0)
		return choice;
	else
	{
		FILE* fp = fopen("rock_scissor_paper.txt", "r");
		if (fp == NULL)
		{
			return 0;
		}

		while (1)
		{
			fgets(tmpBuf, 1024, fp);
			if (feof(fp))
				break;
			len = (int)strlen(tmpBuf);
			tmpBuf[len - 1] = '\0';

			if (cnt == 0)
			{				
				youMoney = atoi(tmpBuf);
			}
			if (cnt == 1)
			{				
				comMoney = atoi(tmpBuf);
			}
			if (cnt == 2)
			{					
				winRate = atoi(tmpBuf);
				cnt = 0;
			}
			

			memset(tmpBuf, '\0', 1024);
			cnt++;			
		}

		setMoney(comMoney, youMoney);
		setWinRate(winRate);
		fclose(fp);
		ShowMoney();

		return choice;
	}	
		
}

void setGameSave(int com_money, int gamer_money, int win_rate)
{
	int choice = 0;
	char buf[1024] = { '\0' };

	printf("게임 내용을 저장하시겠습니까? (Yes 1, No 0): ");
	scanf("%d", &choice);
	assert(choice == 1 || choice == 0);

	if (choice == 0)
		return;
	else
	{		

		FILE* fp = fopen("rock_scissor_paper.txt", "w");
		if (fp == NULL)
		{
			puts("open error!!!");
			return;
		}

		sprintf(buf, "%d\n%d\n%d\n", gamer_money, com_money, win_rate);
		fwrite(buf, sizeof(buf), 1, fp);

		fclose(fp);
	}
}