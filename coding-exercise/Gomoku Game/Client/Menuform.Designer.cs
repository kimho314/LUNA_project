namespace Client
{
    partial class Menuform
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
            this.singlePlayButton = new System.Windows.Forms.Button();
            this.exitButton = new System.Windows.Forms.Button();
            this.multiPlayButton = new System.Windows.Forms.Button();
            this.AIPlayButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // singlePlayButton
            // 
            this.singlePlayButton.Location = new System.Drawing.Point(262, 58);
            this.singlePlayButton.Name = "singlePlayButton";
            this.singlePlayButton.Size = new System.Drawing.Size(100, 40);
            this.singlePlayButton.TabIndex = 0;
            this.singlePlayButton.Text = "Single Play";
            this.singlePlayButton.UseVisualStyleBackColor = true;
            this.singlePlayButton.Click += new System.EventHandler(this.SinglePlayButton_Click);
            // 
            // exitButton
            // 
            this.exitButton.Location = new System.Drawing.Point(262, 242);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(100, 40);
            this.exitButton.TabIndex = 1;
            this.exitButton.Text = "Exit";
            this.exitButton.UseVisualStyleBackColor = true;
            this.exitButton.Click += new System.EventHandler(this.ExitButton_Click);
            // 
            // multiPlayButton
            // 
            this.multiPlayButton.Location = new System.Drawing.Point(262, 117);
            this.multiPlayButton.Name = "multiPlayButton";
            this.multiPlayButton.Size = new System.Drawing.Size(100, 40);
            this.multiPlayButton.TabIndex = 2;
            this.multiPlayButton.Text = "Multi Play";
            this.multiPlayButton.UseVisualStyleBackColor = true;
            this.multiPlayButton.Click += new System.EventHandler(this.MultiPlayButton_Click);
            // 
            // AIPlayButton
            // 
            this.AIPlayButton.Location = new System.Drawing.Point(262, 180);
            this.AIPlayButton.Name = "AIPlayButton";
            this.AIPlayButton.Size = new System.Drawing.Size(100, 40);
            this.AIPlayButton.TabIndex = 3;
            this.AIPlayButton.Text = "AI Play";
            this.AIPlayButton.UseVisualStyleBackColor = true;
            this.AIPlayButton.Click += new System.EventHandler(this.AIPlayButton_Click);
            // 
            // Menuform
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(584, 361);
            this.Controls.Add(this.AIPlayButton);
            this.Controls.Add(this.multiPlayButton);
            this.Controls.Add(this.exitButton);
            this.Controls.Add(this.singlePlayButton);
            this.Name = "Menuform";
            this.Text = "Gomoku Client";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button singlePlayButton;
        private System.Windows.Forms.Button exitButton;
        private System.Windows.Forms.Button multiPlayButton;
        private System.Windows.Forms.Button AIPlayButton;
    }
}

