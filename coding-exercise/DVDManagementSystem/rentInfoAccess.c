#include "common.h"
#include "rentInfo.h"
#include "cusInfo.h"
#include "cusInfoAccess.h"
#include "screenOut.h"

#define RENT_LEN	100

static dvdRentInfo rentList[RENT_LEN];
static int numOfRentCus = 0;

/*
* 기능 : 대여 정보를 저장
* 반환 : void
*/
void AddRentList(char* ISBN, char* cusID, int rentDay)
{
	strcpy(rentList[numOfRentCus].ISBN, ISBN);
	strcpy(rentList[numOfRentCus].cusID, cusID);
	rentList[numOfRentCus].rentDay = rentDay;
	numOfRentCus++;
}

/*
* 기능 : 특정 ISBN의 DVD 대여 정보 전체 출력
* 반환 : void
*/
void PrintOutRentAllCusInfo(char* ISBN)
{
	cusInfo* tmp_cusInfo = NULL;
	for (int i = 0; i < numOfRentCus; i++)
	{
		fprintf(stdout, "대여일: %d\n", rentList[i].rentDay);
		tmp_cusInfo = GetCusPtrByID(rentList[i].cusID);
		ShowCustomerInfo(tmp_cusInfo);
	}
}

/*
* 기능 : 일정 기간 안에 이뤄진 특정 고개의 DVD 대여 정보 출력
* 반환 : void
*/
void PrintOutCusAllRentInfo(char* ID, unsigned int start, unsigned int end)
{
	for (int i = 0; i < numOfRentCus; i++)
	{
		if (!strcmp(rentList[i].cusID, ID))
		{
			if ((rentList[i].rentDay <= end) && (rentList[i].rentDay >= start))
			{
				fprintf(stdout, "--------------------------------------\n");
				fprintf(stdout, "▶ ISBN : %s\n", rentList[i].ISBN);
				fprintf(stdout, "▶ 대여일 : %d\n", rentList[i].rentDay);
				fprintf(stdout, "--------------------------------------\n");
			}
		}
	}
}