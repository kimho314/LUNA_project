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

    public partial class Form2 : Form
    {
        Calendar Cal = new Calendar();

        public Form2()
        {
            InitializeComponent();           
            
        }            

    
        private void Form2_Load(object sender, EventArgs e)
        {
            InputDate.KeyPress += new KeyPressEventHandler(InputDate_KeyPressEvent);
        }

        private void InputDate_KeyPressEvent(object sender, KeyPressEventArgs e)
        {
            if(e.KeyChar == (char)Keys.Return)
            {
                //Verify_textBox.Text = InputDate.Text;
                
                int ret_year = Int32.Parse(InputDate.Text.Substring(0, 4));
                int ret_month = Int32.Parse(InputDate.Text.Substring(6, 2));
                int ret_day = Int32.Parse(InputDate.Text.Substring(10, 2));
               
                //Verify_textBox.Text = ret_year.ToString() + ret_month.ToString() + ret_day.ToString();

                int ret_date = Cal.printDayOfDate(ret_year, ret_month, ret_day);
                switch(ret_date)
                {
                    case 0:
                        Date_textBox.Text = "Sunday";
                        break;

                    case 1:
                        Date_textBox.Text = "Monday";
                        break;

                    case 2:
                        Date_textBox.Text = "Tuesday";
                        break;

                    case 3:
                        Date_textBox.Text = "Wednesday";
                        break;

                    case 4:
                        Date_textBox.Text = "Thursday";
                        break;

                    case 5:
                        Date_textBox.Text = "Friday";
                        break;

                    case 6:
                        Date_textBox.Text = "Satuday";
                        break;
                }
            }
        }
    }
}
