#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int count_leap_year(const int cur_year, const int birth_year)
{
	int cnt = 0;
	int tmp_year = birth_year;

	do
	{
		tmp_year++;

		if ((tmp_year % 4 == 0) && (tmp_year % 100 != 0) || (tmp_year % 400 == 0))
		{
			cnt++;
		}
	} while (tmp_year != cur_year);
	
	return cnt;
}

int determine_leap_year(const int year)
{	
	if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
	{
		return 1;
	}
	else
		return 0;
}

int main()
{
	int cur_year = 0;
	int birth_year = 0;
	int num_leap_year = 0;

	printf("input current year: ");
	scanf("%d", &cur_year);
	printf("input birth year: ");
	scanf("%d", &birth_year);

	// count number of leap year between current year and birth year
	num_leap_year = count_leap_year(cur_year, birth_year);
	printf("number of leap year between %d and %d : %d\n", birth_year, cur_year, num_leap_year);
	

	return 0;
}