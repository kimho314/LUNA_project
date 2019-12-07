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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();            
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }       

        private void Select_button_Click(object sender, EventArgs e)
        {
            Hide();
            if(radioButton1.Checked)
            {
                Form2 form2 = new Form2();
                form2.FormClosed += new FormClosedEventHandler(childForm_Closed);
                form2.Show();
            }
            if(radioButton2.Checked)
            {
                Form3 form3 = new Form3();
                form3.FormClosed += new FormClosedEventHandler(childForm_Closed);
                form3.Show();
            }
        }

        void childForm_Closed(object sender, FormClosedEventArgs e)
        {
            Show();
        }

        private void ExitButton_Click(object sender, EventArgs e)
        {
            System.Windows.Forms.Application.Exit();
        }
    }
}
