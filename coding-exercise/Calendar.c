#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STANDARD_YEAR		1583
#define MAX_CALENDER_LAN	42

int days_of_month[12] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

enum Day
{
	SUNDAY, // 0
	MONDAY, // 1
	TUESDAY, // 2
	WEDNESDAY, // 3
	THURSDAY, // 4
	FRIDAY, // 5
	SATURDAY, // 6
};

int is_leap_year(const int year);
int get_num_leap_year(const int year);
int get_num_common_year(const int year);
int get_day_of_firstdate(const int year);
void print_day_of_date(const int year, const int month, const int day);
void print_calendar(const int year, const int month);


int main(int argc, char *argv[])
{
	int year = 0;
	int month = 0;
	int day = 0;
	int select_menu = 0;
	
	while (1)
	{
		printf("0. quit  1. print the day  2. print the calendar\n");
		scanf("%d", &select_menu);

		switch (select_menu)
		{
		case 0:
			exit(1);
			break;

		case 1:
			printf("enter date(year month day): ");
			scanf("%d%d%d", &year, &month, &day);
			if ((year <= STANDARD_YEAR) || (month < 1) || (day < 1))
			{
				puts("year > STANDARD_YEAR || month >= 1 || day >= 1\n");
				continue;
			}
			print_day_of_date(year, month, day);
			break;

		case 2:
			printf("enter year and month: ");
			scanf("%d%d", &year, &month);
			if ((year <= STANDARD_YEAR) || (month < 1))
			{
				puts("year > STANDARD_YEAR || month >= 1\n");
				continue;
			}
			print_calendar(year, month);
			break;

		default:
			printf("corrupted input!!!");
			break;
		}
		printf("\n");
	}

	return 0;
}

int is_leap_year(const int year)
{
	if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
		return 1;
	else
		return 0;
}

int get_num_leap_year(const int year)
{
	int num_leap_year_present = 0;
	int num_leap_year_standard = 0;
	int num_leap_year = 0;
	int standard_year = STANDARD_YEAR - 1;

	num_leap_year_present = (year / 4) - (year / 100) + (year / 400);
	num_leap_year_standard = (standard_year / 4) - (standard_year / 100) + (standard_year / 400);
	num_leap_year = num_leap_year_present - num_leap_year_standard;

	return num_leap_year;
}

int get_num_common_year(const int year)
{
	int num_diff_year = 0;
	int num_comm_year = 0;
	int num_leap_year = 0;

	num_diff_year = year - STANDARD_YEAR + 1;
	num_leap_year = get_num_leap_year(year);
	num_comm_year = num_diff_year - num_leap_year;

	return num_comm_year;
}

int get_day_of_firstdate(const int year)
{
	int day_of_firstdate = -1;
	int num_comm_year = 0;
	int num_leap_year = 0;

	num_leap_year = get_num_leap_year(year - 1);
	num_comm_year = get_num_common_year(year - 1);
	day_of_firstdate = (SATURDAY + (num_comm_year * 1 + num_leap_year * 2) % 7) % 7;

	return day_of_firstdate;
}

void print_day_of_date(const int year, const int month, const int day)
{
	int i = 0;
	int days_prev_month = 0;
	int ret_day = -1;

	days_prev_month = get_day_of_firstdate(year);
	for (i = 0; i < month - 1; i++)
	{
		days_prev_month += days_of_month[i];
	}
	ret_day = (days_prev_month + day - 1) % 7;

	printf("%d/%d/%d is ", day, month, year);
	switch (ret_day)
	{
	case SUNDAY:
		printf("Sunday\n");
		break;

	case MONDAY:
		printf("Monday\n");
		break;

	case TUESDAY:
		printf("Tuesday\n");
		break;

	case WEDNESDAY:
		printf("Wednesday\n");
		break;

	case THURSDAY:
		printf("Thursday\n");
		break;

	case FRIDAY:
		printf("Friday\n");
		break;

	case SATURDAY:
		printf("Saturday\n");
		break;
	}
}

void print_calendar(const int year, const int month)
{
	int i = 0;
	int day_of_firstdate = 0;
	int days_prev_month = 0;
	int ret_day = -1;
	int cnt = 1;
	int tmp = 0;

	if (is_leap_year(year))
		days_of_month[1] = 29;
	else
		days_of_month[1] = 28;

	day_of_firstdate = get_day_of_firstdate(year);
	days_prev_month = get_day_of_firstdate(year);
	for (i = 0; i < month - 1; i++)
	{
		days_prev_month += days_of_month[i];
	}
	ret_day = (days_prev_month + 1 - 1) % 7;
	
	printf("  Sun Mon Tue Wed Thu Fri Sat  \n");
	
	for (i = 0; i < MAX_CALENDER_LAN; i++)
	{
		if (i >= ret_day && i < (ret_day + days_of_month[month-1]))
			printf("%4d", cnt++);
		else
			printf("    ");

		if (i % 7 == 6)
			printf("\n");
	}
	printf("\n");
}