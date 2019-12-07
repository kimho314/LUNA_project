using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calendar_ver2
{
    public partial class Form3 : Form
    {
        Calendar Cal = new Calendar();
        int year_in = 0;
        int month_in = 0;
        int day_in = 0;
        int cnt = 1;
        int enter_cnt = 0;
        List<int> dateList = new List<int>();
        

        public Form3()
        {
            InitializeComponent();
            this.Load += new EventHandler(Form3_Load);
        }
      

        private void Form3_Load(object sender, EventArgs e)
        {
            maskedTextBox1.KeyPress += new KeyPressEventHandler(InputDate_KeyPressEvent);
            SetupDataGridView();            
        }

        private void SetupDataGridView()
        {
            this.Controls.Add(calendarGridView);
            calendarGridView.ColumnCount = 7;

            calendarGridView.Columns[0].Name = "Sun";
            calendarGridView.Columns[1].Name = "Mon";
            calendarGridView.Columns[2].Name = "Tue";
            calendarGridView.Columns[3].Name = "Wed";
            calendarGridView.Columns[4].Name = "Thu";
            calendarGridView.Columns[5].Name = "Fri";
            calendarGridView.Columns[6].Name = "Sat";
        }

        private void UpdateDataGridView()
        {
            // columns : 7, rows : 7
            string[] st = new string[7];

            for(int i=0; i<dateList.Count(); i++)
            {
                if(dateList[i] == -1)
                {
                    st[i % 7] = " ";
                }
                else
                    st[i % 7] = dateList[i].ToString();

                if (i % 7 == 6)
                {
                    calendarGridView.Rows.Add(st);
                    Array.Clear(st, 0, st.Length);
                }
            }            
        }

        private void InputDate_KeyPressEvent(object sender, KeyPressEventArgs e)
        {           
            if(enter_cnt < 0)
            {
                enter_cnt = 0;
            }

            if (e.KeyChar == (char)Keys.Enter)
            {               
                enter_cnt++;
                year_in = Int32.Parse(maskedTextBox1.Text.Substring(0, 4));
                month_in = Int32.Parse(maskedTextBox1.Text.Substring(6, 2));
                day_in = Int32.Parse(maskedTextBox1.Text.Substring(10, 2));
                
                /* calculate data */
                if (Cal.isLeapYear(year_in) == 1)
                    Cal.DaysOfMonth[1] = 29;
                else
                    Cal.DaysOfMonth[1] = 28;

                int days_prev_month = Cal.getDayOfFirstDate(year_in);
                for (int i = 0; i < month_in - 1; i++)
                {
                    days_prev_month += Cal.DaysOfMonth[i];
                }
                int ret_day = (days_prev_month) % 7;

                
                for (int i = 0; i < Cal.MAX_CALENDAR_LEN; i++)
                {
                    if (i >= ret_day && i < (ret_day + Cal.DaysOfMonth[month_in - 1]))
                    {                        
                        dateList.Add(cnt);
                        cnt++;
                    }
                    else
                    {                       
                        dateList.Add(-1);
                    }

                    if (i % 7 == 6)
                    { }
                }
                                
            }

            if (enter_cnt % 2 == 1)
            {
                calendarGridView.Rows.Clear();
                UpdateDataGridView();                
            }
            cnt = 1;
            dateList.Clear();
            enterTextBox.Text = enter_cnt.ToString();
        }      
        
    }
}
