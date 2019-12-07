namespace Calendar_ver2
{
    partial class Form1
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
            this.Menu_groupBox = new System.Windows.Forms.GroupBox();
            this.radioButton2 = new System.Windows.Forms.RadioButton();
            this.radioButton1 = new System.Windows.Forms.RadioButton();
            this.Select_button = new System.Windows.Forms.Button();
            this.Title_label = new System.Windows.Forms.Label();
            this.exitButton = new System.Windows.Forms.Button();
            this.Menu_groupBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // Menu_groupBox
            // 
            this.Menu_groupBox.Controls.Add(this.radioButton2);
            this.Menu_groupBox.Controls.Add(this.radioButton1);
            this.Menu_groupBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Menu_groupBox.Location = new System.Drawing.Point(59, 90);
            this.Menu_groupBox.Margin = new System.Windows.Forms.Padding(2);
            this.Menu_groupBox.Name = "Menu_groupBox";
            this.Menu_groupBox.Padding = new System.Windows.Forms.Padding(2);
            this.Menu_groupBox.Size = new System.Drawing.Size(172, 101);
            this.Menu_groupBox.TabIndex = 1;
            this.Menu_groupBox.TabStop = false;
            this.Menu_groupBox.Text = "Menu";
            // 
            // radioButton2
            // 
            this.radioButton2.AutoSize = true;
            this.radioButton2.Location = new System.Drawing.Point(24, 58);
            this.radioButton2.Margin = new System.Windows.Forms.Padding(2);
            this.radioButton2.Name = "radioButton2";
            this.radioButton2.Size = new System.Drawing.Size(104, 28);
            this.radioButton2.TabIndex = 1;
            this.radioButton2.TabStop = true;
            this.radioButton2.Text = "Calendar";
            this.radioButton2.UseVisualStyleBackColor = true;
            // 
            // radioButton1
            // 
            this.radioButton1.AutoSize = true;
            this.radioButton1.Location = new System.Drawing.Point(24, 27);
            this.radioButton1.Margin = new System.Windows.Forms.Padding(2);
            this.radioButton1.Name = "radioButton1";
            this.radioButton1.Size = new System.Drawing.Size(152, 28);
            this.radioButton1.TabIndex = 0;
            this.radioButton1.TabStop = true;
            this.radioButton1.Text = "Day of the date";
            this.radioButton1.UseVisualStyleBackColor = true;
            // 
            // Select_button
            // 
            this.Select_button.Location = new System.Drawing.Point(59, 196);
            this.Select_button.Margin = new System.Windows.Forms.Padding(2);
            this.Select_button.Name = "Select_button";
            this.Select_button.Size = new System.Drawing.Size(169, 41);
            this.Select_button.TabIndex = 2;
            this.Select_button.Text = "Select";
            this.Select_button.UseVisualStyleBackColor = true;
            this.Select_button.Click += new System.EventHandler(this.Select_button_Click);
            // 
            // Title_label
            // 
            this.Title_label.AutoSize = true;
            this.Title_label.Font = new System.Drawing.Font("Microsoft Sans Serif", 25.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Title_label.Location = new System.Drawing.Point(76, 15);
            this.Title_label.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.Title_label.Name = "Title_label";
            this.Title_label.Size = new System.Drawing.Size(157, 39);
            this.Title_label.TabIndex = 3;
            this.Title_label.Text = "Calendar";
            // 
            // exitButton
            // 
            this.exitButton.Location = new System.Drawing.Point(59, 252);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(169, 41);
            this.exitButton.TabIndex = 4;
            this.exitButton.Text = "Exit";
            this.exitButton.UseVisualStyleBackColor = true;
            this.exitButton.Click += new System.EventHandler(this.ExitButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(299, 307);
            this.Controls.Add(this.exitButton);
            this.Controls.Add(this.Title_label);
            this.Controls.Add(this.Select_button);
            this.Controls.Add(this.Menu_groupBox);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.Menu_groupBox.ResumeLayout(false);
            this.Menu_groupBox.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.GroupBox Menu_groupBox;
        private System.Windows.Forms.RadioButton radioButton2;
        private System.Windows.Forms.RadioButton radioButton1;
        private System.Windows.Forms.Button Select_button;
        private System.Windows.Forms.Label Title_label;
        private System.Windows.Forms.Button exitButton;
    }
}

