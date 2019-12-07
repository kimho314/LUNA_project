#include "common.h"
#include "cusInfo.h"

#define MAX_CUSTOMER	100

static cusInfo* cusList[MAX_CUSTOMER];
static int numOfCustomer = 0;

/*
* 기능: cusInfo 할당 및 저장
* 반환: 성공 시 '등록된 정보의 개수', 실패 시 0 반환
*/
int AddCusInfo(char* ID, char* name, char* num)
{
	cusList[numOfCustomer] = (cusInfo*)malloc(sizeof(cusInfo));
	memset(cusList[numOfCustomer], 0, sizeof(cusList[numOfCustomer]));
	strcpy(cusList[numOfCustomer]->ID, ID);
	strcpy(cusList[numOfCustomer]->name, name);
	strcpy(cusList[numOfCustomer]->phoneNum, num);
	numOfCustomer++;
	
	if (cusList[numOfCustomer - 1] == NULL)
		return 0;
	else
		return numOfCustomer;
}

/*
* 기능: 해당 ID의 정보를 담고 있는 변수의 포인터 반환
* 반환: 등록 안된 ID의 경우 NULL 포인터 반환
*/
cusInfo* GetCusPtrByID(char* ID)
{
	for (int i = 0; i < numOfCustomer; i++)
	{
		if (!strcmp(cusList[i]->ID, ID))
			return cusList[i];
	}

	return NULL;
}

/*
* 기능: 해당 ID의 정보를 답고 있는 변수를 삭제
* 번환: void
*/
void DelCusPtrByID(char* ID)
{
	for (int i = 0; i < numOfCustomer; i++)
	{
		if (!strcmp(cusList[i]->ID, ID))
		{
			free(cusList[i]);
			numOfCustomer--;
			puts("delete complete");
		}
	}

}

/*
* 기능: 가입 된 ID인지 확인
* 반환: 가입 되었으면 1, 아니면 0반환
*/
int IsRegistID(char* ID)
{
	for (int i = 0; i < numOfCustomer; i++)
	{
		if (!strcmp(cusList[i]->ID, ID))
			return 1;
	}
	return 0;
}