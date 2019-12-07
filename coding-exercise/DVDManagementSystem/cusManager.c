#include "common.h"
#include "cusInfo.h"
#include "cusInfoAccess.h"
#include "screenOut.h"
#include "cusManager.h"

/*
* 기능: 신규 회원 가입
* 반환: void
*/
void RegistCustomer()
{
	char ID[ID_LEN] = { 0 };
	char name[NAME_LEN] = { 0 };
	char num[PHONE_LEN] = { 0 };

	while (1)
	{
		printf("ID입력: ");
		fgets(ID, ID_LEN, stdin);
		if (IsRegistID(ID))
		{
			puts("해당 ID는 사용 중에 있습니다.");
			getchar();
			continue;
		}
		else
			break;
	}
	printf("이름 입력: ");
	fgets(name, NAME_LEN, stdin);
	printf("전화번호 입력: ");
	fgets(num, PHONE_LEN, stdin);
	
	if (AddCusInfo(ID, name, num))
	{
		puts("가입이 완료되었습니다");
	}
}

/*
* 기능: ID를 통한 회원 정보 검색
* 반환: void
*/
void SearchCusInfo()
{
	char ID[ID_LEN] = { 0 };
	cusInfo* tmp_cusInfo = NULL;

	printf("찾는 ID 입력: ");
	fgets(ID, ID_LEN, stdin);
	tmp_cusInfo = GetCusPtrByID(ID);
	if (tmp_cusInfo != NULL)
	{
		ShowCustomerInfo(tmp_cusInfo);
		puts("조회가 완료되었습니다.");
	}
	else
	{
		puts("해당 ID를 조회할 수 없습니다.");
		getchar();
		return;
	}
}

