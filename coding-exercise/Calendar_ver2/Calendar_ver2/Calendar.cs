using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calendar_ver2
{
    public class Calendar
    {
        public int STANDARD_YEAR = 1583;
        public int MAX_CALENDAR_LEN = 42;

        public int[] DaysOfMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        public enum Day
        {
            SUNDAY,
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY,
            FRIDAY,
            SATURDAY,
        };

        public int isLeapYear(int year)
        {
            if (((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)))
            {
                return 1;
            }
            else
                return 0;
        }

        public int getNumLeapYear(int year)
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

        public int getNumCommonYear(int year)
        {
            int num_diff_year = 0;
            int num_comm_year = 0;
            int num_leap_year = 0;

            num_diff_year = year - STANDARD_YEAR + 1;
            num_leap_year = getNumLeapYear(year);
            num_comm_year = num_diff_year - num_leap_year;

            return num_comm_year;
        }

        public int getDayOfFirstDate(int year)
        {
            int day_of_firstdate = -1;
            int num_comm_year = 0;
            int num_leap_year = 0;

            num_leap_year = getNumLeapYear(year - 1);
            num_comm_year = getNumCommonYear(year - 1);
            day_of_firstdate = ((int)Day.SATURDAY + ((num_comm_year * 1) + (num_leap_year * 2)) % 7) % 7;

            return day_of_firstdate;
        }

        public int printDayOfDate(int year, int month, int day)
        {
            int i = 0;
            int days_prev_month = 0;
            int ret_day = -1;

            days_prev_month = getDayOfFirstDate(year);
            for (i = 0; i < month - 1; i++)
            {
                days_prev_month += DaysOfMonth[i];
            }
            ret_day = (days_prev_month + day - 1) % 7;

            return ret_day;
        }

        public void printCalendar(int year, int month)
        {
            int i = 0;
            int day_of_firstdate = 0;
            int days_prev_month = 0;
            int ret_day = -1;
            int cnt = 1;
            int tmp = 0;

            if (isLeapYear(year) == 1)
                DaysOfMonth[1] = 29;
            else
                DaysOfMonth[1] = 28;

            day_of_firstdate = getDayOfFirstDate(year);
            days_prev_month = getDayOfFirstDate(year);
            for (i = 0; i < month - 1; i++)
            {
                days_prev_month += DaysOfMonth[i];
            }
            ret_day = (days_prev_month + 1 - 1) % 7;
        }
    }
}
