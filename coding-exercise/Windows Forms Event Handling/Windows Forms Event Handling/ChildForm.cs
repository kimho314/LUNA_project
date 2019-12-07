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
    public partial class ChildForm : Form
    {
        private DataTransferInterface dataTransferInterface = null;

        public ChildForm(DataTransferInterface dataTransferInterface)
        {
            InitializeComponent();
            this.dataTransferInterface = dataTransferInterface;
            transferButton.Enabled = false;
        }
               

        private void DataTextBox_TextChanged(object sender, EventArgs e)
        {
            if(dataTextBox.Text.Length >= 6)
            {
                statusLabel.Text = "전송해주세요.";
                transferButton.Enabled = true;
            }
            else
            {
                statusLabel.Text = "너무 짧습니다.";
                transferButton.Enabled = false;
            }
        }

        private void TransferButton_Click(object sender, EventArgs e)
        {
            dataTransferInterface.transfer(dataTextBox.Text);
            Close();
        }
    }
}
