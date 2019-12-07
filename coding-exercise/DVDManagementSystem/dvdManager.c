#include "common.h"
#include "dvdInfo.h"
#include "dvdInfoAccess.h"
#include "screenOut.h"
#include "dvdManager.h"

extern void PrintOutRentAllCusInfo(char* ISBN);
extern void PrintOutCusAllRentInfo(char* ID, unsigned int start, unsigned int end);

void RegistDvd()
{
	char ISBN[ISBN_LEN] = { 0 };
	char title[TITLE_LEN] = { 0 };
	int genre = 0;
	int ret = -1;

	while (1)
	{
		printf("ISBN입력: ");
		fgets(ISBN, ISBN_LEN, stdin);
		if (IsRegistISBN(ISBN))
		{
			puts("해당 ISBN은 사용 중에 있습니다.");
			continue;
		}
		else
			break;
	}
	printf("제목 입력: ");
	fgets(title, TITLE_LEN, stdin);
	printf("장르 입력(1.ACTION, 2.COMIC, 3.SF, 4.ROMANTIC): ");
	scanf("%d", &genre);

	ret = AddDvdInfo(ISBN, title, genre);
	if (ret)
	{
		puts("DVD 정보 추가가 완료되었습니다.");
		getchar();
	}
	else
		return;
}

void SearchDvdInfo()
{
	char ISBN[ISBN_LEN] = { 0 };
	dvdInfo* tmp_dvdinfo = NULL;

	printf("찾는 ISBN입력: ");
	fgets(ISBN, ISBN_LEN, stdin);
	tmp_dvdinfo = GetDvdPtrByISBN(ISBN);
	if (tmp_dvdinfo != NULL)
	{
		ShowDvdInfo(tmp_dvdinfo);
		puts("조회가 완료되었습니다.");
	}
	else
	{
		puts("해당 ISBN을 조회할 수 없습니다.");
		getchar();
		return;
	}
}

void RentDvd()
{
	char ISBN[ISBN_LEN] = { 0 };
	int ret = -1;

	printf("대여 DVD ISBN 입력: ");
	fgets(ISBN, ISBN_LEN, stdin);
	if (IsRentedISBN(ISBN) == 1)
	{
		puts("대여가 가능합니다. 대여 과정을 진행합니다.");
		ret = AddRentInfo(ISBN);
		if (ret)
		{
			puts("대여가 완료 되었습니다.");
		}
	}
	else
	{
		puts("대여가 불가능합니다.");
	}

	getchar();
}

void ReturnDvd()
{
	char ISBN[ISBN_LEN] = { 0 };
	int ret = -1;

	printf("대여 DVD ISBN 입력: ");
	fgets(ISBN, ISBN_LEN, stdin);
	if (IsRentedISBN(ISBN) == 0)
	{
		if (ReturnRentedInfo(ISBN))
		{
			puts("반납이 완료 되었습니다.");
		}
	}
	else
	{
		puts("반납이 됬거나 없는 DVD입니다.");
	}

	getchar();
}

void ShowRentCusInfo()
{
	char ISBN[ISBN_LEN] = { 0 };
	int ret = -1;

	printf("찾는 DVD ISBN 입력: ");
	fgets(ISBN, ISBN_LEN, stdin);
	if (IsRentedISBN(ISBN) != -1)
	{
		PrintOutRentAllCusInfo(ISBN);
		puts("조회가 완료되었습니다.");
		getchar();
	}
}

void ShowCusRentInfo()
{
	char ID[ID_LEN] = { 0 };
	int ret = -1;
	int start_day = 0, end_day = 0;

	printf("찾는 ID 입력: ");
	fgets(ID, ISBN_LEN, stdin);
	printf("시작 날짜와 마지막 날짜 입력(YYYYMMDD): ");
	scanf("%d %d", &start_day, &end_day);
	PrintOutCusAllRentInfo(ID, start_day, end_day);
	puts("조회가 완료되었습니다.");
	getchar();
}