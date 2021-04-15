
namespace Uranai
{
    partial class FormUranai
    {
        /// <summary>
        /// 必要なデザイナー変数です。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 使用中のリソースをすべてクリーンアップします。
        /// </summary>
        /// <param name="disposing">マネージド リソースを破棄する場合は true を指定し、その他の場合は false を指定します。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows フォーム デザイナーで生成されたコード

        /// <summary>
        /// デザイナー サポートに必要なメソッドです。このメソッドの内容を
        /// コード エディターで変更しないでください。
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.dateTimeUranai = new System.Windows.Forms.DateTimePicker();
            this.buttonUranaiStart = new System.Windows.Forms.Button();
            this.pictureBoxResult = new System.Windows.Forms.PictureBox();
            this.textResult = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxResult)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(63, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "今日の日付";
            // 
            // dateTimeUranai
            // 
            this.dateTimeUranai.Location = new System.Drawing.Point(82, 8);
            this.dateTimeUranai.Name = "dateTimeUranai";
            this.dateTimeUranai.Size = new System.Drawing.Size(190, 19);
            this.dateTimeUranai.TabIndex = 1;
            // 
            // buttonUranaiStart
            // 
            this.buttonUranaiStart.Location = new System.Drawing.Point(15, 29);
            this.buttonUranaiStart.Name = "buttonUranaiStart";
            this.buttonUranaiStart.Size = new System.Drawing.Size(256, 23);
            this.buttonUranaiStart.TabIndex = 2;
            this.buttonUranaiStart.Text = "占う";
            this.buttonUranaiStart.UseVisualStyleBackColor = true;
            this.buttonUranaiStart.Click += new System.EventHandler(this.buttonUranaiStart_Click);
            // 
            // pictureBoxResult
            // 
            this.pictureBoxResult.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pictureBoxResult.Image = global::Uranai.Properties.Resources.Title;
            this.pictureBoxResult.Location = new System.Drawing.Point(15, 58);
            this.pictureBoxResult.Name = "pictureBoxResult";
            this.pictureBoxResult.Size = new System.Drawing.Size(256, 100);
            this.pictureBoxResult.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBoxResult.TabIndex = 3;
            this.pictureBoxResult.TabStop = false;
            // 
            // textResult
            // 
            this.textResult.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textResult.Location = new System.Drawing.Point(15, 164);
            this.textResult.Multiline = true;
            this.textResult.Name = "textResult";
            this.textResult.Size = new System.Drawing.Size(256, 70);
            this.textResult.TabIndex = 4;
            // 
            // FormUranai
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.textResult);
            this.Controls.Add(this.pictureBoxResult);
            this.Controls.Add(this.buttonUranaiStart);
            this.Controls.Add(this.dateTimeUranai);
            this.Controls.Add(this.label1);
            this.Name = "FormUranai";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show;
            this.Text = "占い";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxResult)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DateTimePicker dateTimeUranai;
        private System.Windows.Forms.Button buttonUranaiStart;
        private System.Windows.Forms.PictureBox pictureBoxResult;
        private System.Windows.Forms.TextBox textResult;
    }
}

