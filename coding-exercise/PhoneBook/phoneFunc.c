#include "common.h"
#include "phoneData.h"
#include "phoneFunc.h"
#include "screenOut.h"

#define LIST_NUM	100

int numOfData = 0;
phoneData *phoneList[LIST_NUM];

int CheckDup(char* name_in, char * phonenum_in)
{
	int ret = 0;

	for (int i = 0; i < numOfData; i++)
	{
		if (!strcmp(name_in, phoneList[i]->name))
			ret++;
		if (!strcmp(phonenum_in, phoneList[i]->phoneNum))
			ret++;

		if (ret >= 2)
			break;
	}

	return ret;
}

void InputPhoneData()
{
	char name_in[LIST_NUM] = { 0 };
	char phonenum_in[LIST_NUM] = { 0 };
	int ret = 0;

	if (numOfData >= LIST_NUM)
	{
		puts("out of memory");
		return;
	}

	printf("이름 입력: ");
	gets(name_in);
	printf("번호 입력: ");
	gets(phonenum_in);

	if (numOfData >= 1)
	{
		ret = CheckDup(name_in, phonenum_in);

		if (ret >= 2)
		{
			puts("중복되는 전화번호 입니다!");
			getchar();
			return;
		}
	}

	phoneList[numOfData] = (phoneData*)malloc(sizeof(phoneData));
	strcpy(phoneList[numOfData]->name, name_in);
	strcpy(phoneList[numOfData]->phoneNum, phonenum_in);
	numOfData++;
	puts("저장이 완료 되었습니다");
	StoreDataToFile();
	getchar();
}

void ShowAllData()
{
	if (numOfData <= 0)
	{
		puts("no data");
		return;
	}

	for (int i = 0; i < numOfData; i++)
	{
		ShowPhoneInfoByPtr(phoneList[i]);
	}
	getchar();
}

void SearchPhoneData()
{
	char name_in[LIST_NUM] = { 0 };
	int idx = -1;
		

	printf("이름 입력: ");
	gets(name_in);

	for (int i = 0; i < numOfData; i++)
	{
		if (strcmp(name_in, phoneList[i]->name) == 0)
		{
			idx = i;
			ShowPhoneInfoByPtr(phoneList[idx]);
		}
	}

	if (idx == -1)
	{
		puts("no name");
		return;
	}
	
	puts("검색이 완료 되었습니다");
	getchar();
}

void DeletePhoneData()
{
	char name_in[LIST_NUM] = { 0 };
	int idx = -1;
	int tmpList[LIST_NUM] = { 0 };
	int delNum = 0;

	if (numOfData == 0)
	{
		puts("underflow");
		return;
	}

	printf("이름 입력: ");
	gets(name_in);

	for (int i = 0; i < numOfData; i++)
	{
		if (strcmp(name_in, phoneList[i]->name) == 0)
		{
			idx++;
			tmpList[idx] = i;
		}
	}

	if (idx == -1)
	{
		puts("no name");
		return;
	}
	
	if (idx >= 1)
	{
		for (int i = 0; i <= idx; i++)
		{
			printf("NUM: %d\n", i + 1);
			ShowPhoneInfoByPtr(phoneList[tmpList[i]]);
		}
		printf("삭제 번호를 고르세요: ");
		scanf("%d", &delNum);
		assert(delNum > 0);

		for (int i = tmpList[delNum - 1]; i < numOfData - 1; i++)
		{
			strcpy(phoneList[i]->name, phoneList[i + 1]->name);
			strcpy(phoneList[i]->phoneNum, phoneList[i + 1]->phoneNum);
		}
		free(phoneList[numOfData - 1]);
	}
	else
	{
		for (int i = tmpList[0]; i < numOfData - 1; i++)
		{
			strcpy(phoneList[i]->name, phoneList[i + 1]->name);
			strcpy(phoneList[i]->phoneNum, phoneList[i + 1]->phoneNum);
		}
		free(phoneList[numOfData - 1]);
	}
	   	
	numOfData--;
	puts("삭제가 완료 되었습니다");
	StoreDataToFile();
	getchar();
}

void StoreDataToFile()
{
	char tmpstr[LIST_NUM] = { '\0' };
	int len = 0;

	if (numOfData <= 0)
	{
		puts("store error!!!");
		return;
	}

	FILE* fp = fopen("phonebook.txt", "w");
	if (fp == NULL)
	{
		puts("open error!!!");
		return;
	}

	for (int i = 0; i < numOfData; i++)
	{
		sprintf(tmpstr, "%s %s\n", phoneList[i]->name, phoneList[i]->phoneNum);
		len = (int)strlen(tmpstr);
		fwrite(tmpstr, len, 1, fp);
	}
	fclose(fp);

	printf("저장이 완료됬습니다");
	getchar();
}

void LoadDataFromFile()
{
	char tmpstr[LIST_NUM] = { '\0' };
	int len = 0;
	int idx = 0;
	char* pstr = NULL;
	
	FILE* fp = fopen("phonebook.txt", "r");
	if (fp == NULL)
	{
		puts("open error!!!");
		return;
	}

	while (1)
	{
		if (feof(fp) != 0)
			break;
		fread(tmpstr, LIST_NUM, 1, fp);
		//fprintf(stdout, "%s\n", tmpstr);

		pstr = strtok(tmpstr, "\n");
		while (pstr != NULL)
		{
			phoneList[numOfData] = (phoneData*)malloc(sizeof(phoneData));
			len = (int)strlen(pstr);
			for (int i = 0; i < len; i++)
			{
				if (pstr[i] == ' ')
				{
					idx = i;
					break;
				}
			}
			
			for (int i = 0; i < idx; i++)
			{
				phoneList[numOfData]->name[i] = pstr[i];
			}
			phoneList[numOfData]->name[idx] = '\0';

			int j = 0;
			for (int i = idx + 1; i < len; i++)
			{
				phoneList[numOfData]->phoneNum[j++] = pstr[i];
			}
			phoneList[numOfData]->phoneNum[j] = '\0';
			j = 0;

			pstr = strtok(NULL, "\n");
			numOfData++;
		}
	}
	fclose(fp);

	printf("불러오기가 완료됬습니다");
	getchar();
}

void ChangePhoneData()
{
	char name_in[LIST_NUM] = { 0 };
	char phoneNum[LIST_NUM] = { 0 };
	int idx = -1;
	int tmpList[LIST_NUM] = { 0 };
	int selNum = 0;

	if (phoneList[0] != NULL)
	{
		for (int i = 0; i < numOfData; i++)
			phoneList[i] = NULL;
		numOfData = 0;
	}
	LoadDataFromFile();
	ShowAllData();

	if (numOfData == 0)
	{
		puts("underflow");
		return;
	}

	printf("이름 입력: ");
	gets(name_in);

	for (int i = 0; i < numOfData; i++)
	{
		if (!strcmp(name_in, phoneList[i]->name))
		{
			idx++;
			tmpList[idx] = i;
		}
	}

	if (idx == -1)
	{
		puts("no name");
		return;
	}

	if (idx >= 1)
	{
		for (int i = 0; i <= idx; i++)
		{
			printf("NUM: %d\n", i + 1);
			ShowPhoneInfoByPtr(phoneList[tmpList[i]]);
		}
		printf("변경할 번호를 고르세요: ");
		scanf("%d", &selNum);
		assert(selNum > 0);
		selNum--;
			
	}
	else
	{
		selNum = tmpList[0];
	}

	printf("변경할 번호를 입력하세요: ");
	scanf("%s", phoneNum);
	strcpy(phoneList[selNum]->phoneNum, phoneNum);
	getchar();
	puts("변경이 완료 되었습니다");
	StoreDataToFile();
	getchar();
}