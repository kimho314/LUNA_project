namespace Calendar_ver2
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.InputDate = new System.Windows.Forms.MaskedTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.Verify_textBox = new System.Windows.Forms.TextBox();
            this.Date_textBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // InputDate
            // 
            this.InputDate.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.InputDate.Location = new System.Drawing.Point(156, 177);
            this.InputDate.Mask = "0000년 90월 90일";
            this.InputDate.Name = "InputDate";
            this.InputDate.ResetOnSpace = false;
            this.InputDate.Size = new System.Drawing.Size(173, 30);
            this.InputDate.TabIndex = 2;
            this.InputDate.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.InputDate.ValidatingType = typeof(System.DateTime);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 25.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(93, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(319, 51);
            this.label1.TabIndex = 3;
            this.label1.Text = "Day of the Date";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(139, 133);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(213, 32);
            this.label2.TabIndex = 4;
            this.label2.Text = "Enther the Date";
            // 
            // Verify_textBox
            // 
            this.Verify_textBox.Location = new System.Drawing.Point(156, 383);
            this.Verify_textBox.Name = "Verify_textBox";
            this.Verify_textBox.Size = new System.Drawing.Size(173, 22);
            this.Verify_textBox.TabIndex = 5;
            // 
            // Date_textBox
            // 
            this.Date_textBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Date_textBox.Location = new System.Drawing.Point(156, 251);
            this.Date_textBox.Name = "Date_textBox";
            this.Date_textBox.Size = new System.Drawing.Size(173, 30);
            this.Date_textBox.TabIndex = 6;
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(491, 455);
            this.Controls.Add(this.Date_textBox);
            this.Controls.Add(this.Verify_textBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.InputDate);
            this.MaximizeBox = false;
            this.Name = "Form2";
            this.Text = "Form2";
            this.Load += new System.EventHandler(this.Form2_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.MaskedTextBox InputDate;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox Verify_textBox;
        private System.Windows.Forms.TextBox Date_textBox;
    }
}