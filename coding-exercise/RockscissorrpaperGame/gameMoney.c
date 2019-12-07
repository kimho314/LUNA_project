#include "common.h"
#include "gameMoney.h"


int betMoney = 0;
int comMoney = 1000;
int youMoney = 0;


int UpdateMoney(int ret)
{
	int err = 0;

	if (ret == 1)
	{
		comMoney += betMoney;
		youMoney -= betMoney;
	}
	if (ret == 2)
	{
		comMoney -= betMoney;
		youMoney += betMoney;
	}

	if (comMoney == 0)
	{
		err = 1;
	}
	if (youMoney == 0)
	{
		err = 2;
	}

	return err;
}

void ShowMoney()
{
	printf("게이머 머니: %5d\n", youMoney);
	printf("컴퓨터 머니: %5d\n", comMoney);
}

void InitGamerMoney()
{
	int gamerMoney = 0;

	printf("# 당신의 머니를 입력하세요: ");
	scanf("%d", &gamerMoney);
	assert(gamerMoney > 0);

	youMoney = gamerMoney;
	ShowMoney();
}

void UpdateBetMoney()
{
	int money = 0;
	
	while (1)
	{
		printf("판돈을 설정합니다: ");
		scanf("%d", &money);
		assert(money > 0);

		if (money > youMoney)
		{
			printf("소유하고 있는 금액 내에서 거세요!\n");
			continue;
		}
		else if (money > comMoney)
		{
			printf("컴퓨터 소유 금액 초과입니다!\n");
			continue;
		}
		else
			break;

	}
	betMoney = money;
}

void setMoney(int comMoney_in, int gamerMoney_in)
{
	comMoney = comMoney_in;
	youMoney = gamerMoney_in;
}

int getComMoney()
{
	return comMoney;
}

int getGamerMoney()
{
	return youMoney;
}

