#include "common.h"
#include "cusManager.h"
#include "dvdManager.h"
#include "screenOut.h"

enum{CUS_REGIST=1, CUS_SEARCH, DVD_REGIST, DVD_SEARCH, DVD_RENT, DVD_RETURN, DVD_RENT_INFO, CUS_RENT_INFO, QUIT};

int main()
{
	int inputMenu = 0;

	while (1)
	{
		ShowMenu();
		scanf("%d", &inputMenu);
		getchar();

		switch (inputMenu)
		{
		case CUS_REGIST:
			RegistCustomer();
			break;

		case CUS_SEARCH:
			SearchCusInfo();
			break;

		case DVD_REGIST:
			RegistDvd();
			break;

		case DVD_SEARCH:
			SearchDvdInfo();
			break;

		case DVD_RENT:
			RentDvd();
			break;

		case DVD_RETURN:
			ReturnDvd();
			break;

		case DVD_RENT_INFO:
			ShowRentCusInfo();
			break;

		case CUS_RENT_INFO:
			ShowCusRentInfo();
			break;

		default:
			break;
		}

		if (inputMenu == QUIT)
		{
			puts("이용해 주셔서 고마워요");
			break;
		}

		getchar();
	}

	return 0;
}