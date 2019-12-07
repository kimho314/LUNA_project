using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ParentForm
{
    public partial class ParentForm : Form, DataTransferInterface
    {
        public ParentForm()
        {
            InitializeComponent();
        }

        private void OpenChildForm_Click(object sender, EventArgs e)
        {
            ChildForm childForm = new ChildForm(this as DataTransferInterface);
            childForm.Show();
        }

        private void OpenChildForm_MouseHover(object sender, EventArgs e)
        {
            openChildForm.Text = "클릭하세요.";
        }

        private void OpenChildForm_MouseLeave(object sender, EventArgs e)
        {
            openChildForm.Text = "가지마세요.";
        }

        public void transfer(String data)
        {
            dataLabel.Text = data;
        }
    }
}
