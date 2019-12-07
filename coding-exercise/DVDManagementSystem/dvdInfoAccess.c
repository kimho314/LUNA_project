#include "common.h"
#include "dvdInfo.h"
#include "cusInfo.h"
#include "screenOut.h"
#include "cusInfoAccess.h"

#define MAX_DVD	100
#define DATE_LEN	10

extern void AddRentList(char* ISBN, char* cusID, int rentDay);

static dvdInfo* dvdList[MAX_DVD];
static int numOfDvd = 0;

void initDvdInfo(dvdInfo* pDvd)
{
	memset(pDvd->ISBN, 0, ISBN_LEN);
	memset(pDvd->title, 0, TITLE_LEN);
	pDvd->genre = -1;	
	pDvd->rentState = RETURNED;	
}

/*
* assign and save dvdInfo
*/
int AddDvdInfo(char* ISBN, char* title, int genre)
{
	dvdList[numOfDvd] = (dvdInfo*)malloc(sizeof(dvdInfo));
	initDvdInfo(dvdList[numOfDvd]);
	strcpy(dvdList[numOfDvd]->ISBN, ISBN);
	strcpy(dvdList[numOfDvd]->title, title);
	dvdList[numOfDvd]->genre = genre;
	numOfDvd++;

	if (dvdList[numOfDvd - 1] == NULL)
		return 0;
	else
		return numOfDvd;
}

/*
* return the dvd info that has ISBN you want
*/
dvdInfo* GetDvdPtrByISBN(char* ISBN)
{
	for (int i = 0; i < numOfDvd; i++)
	{
		if (!strcmp(dvdList[i]->ISBN, ISBN))
			return dvdList[i];
	}

	return NULL;
}

void DelDvdPtrByISBN(char* ISBN)
{
	for (int i = 0; i < numOfDvd; i++)
	{
		if (!strcmp(dvdList[i]->ISBN, ISBN))
		{
			free(dvdList[i]);
			numOfDvd--;
		}
	}
}

/*
* check if ISBN is registered
*/
int IsRegistISBN(char* ISBN)
{
	for (int i = 0; i < numOfDvd; i++)
	{
		if (!strcmp(dvdList[i]->ISBN, ISBN))
			return 1;
	}
	return 0;
}

/*
* 기능: 해당 ISBN의 대여 상태 확인
* 반환: 등록 안된 ISBN일 시 -1, 대여된 ISBN일 시 0, 반환된 ISBN일 시 1 
*/
int IsRentedISBN(char* ISBN)
{
	dvdInfo* tmp_dvd = NULL;
	int ret = -1;

	ret = IsRegistISBN(ISBN);
	if (ret)
	{
		tmp_dvd = GetDvdPtrByISBN(ISBN);
		return tmp_dvd->rentState;
	}
	else
		return -1;
}

/*
* add DVD rent information
*/
int AddRentInfo(char* ISBN)
{
	char ID[ID_LEN] = { 0 };
	unsigned int rent_date = 0;
	dvdInfo* tmp_dvd = NULL;

	printf("대여 고객 ID 입력: ");
	fgets(ID, ID_LEN, stdin);
	printf("대여 날짜 입력(YYYYMMDD): ");
	scanf("%d", &rent_date);

	AddRentList(ISBN, ID, rent_date);

	tmp_dvd = GetDvdPtrByISBN(ISBN);
	tmp_dvd->rentState = RENTED;

	if (tmp_dvd != NULL)
		return 1;
	else
		return 0;
}

/*
* return rented DVD
*/
int ReturnRentedInfo(char* ISBN)
{
	dvdInfo* tmp_dvd = NULL;

	tmp_dvd = GetDvdPtrByISBN(ISBN);
	tmp_dvd->rentState = RETURNED;
	if (tmp_dvd != NULL)
		return 1;
	else
		return 0;
}

