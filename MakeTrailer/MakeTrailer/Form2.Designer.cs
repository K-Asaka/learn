namespace MakeTrailer
{
    partial class FormEdit
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
            this.dataGridViewContents = new System.Windows.Forms.DataGridView();
            this.DeleteButton = new System.Windows.Forms.DataGridViewButtonColumn();
            this.Content1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Content2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Content3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.buttonOK = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewContents)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridViewContents
            // 
            this.dataGridViewContents.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewContents.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.DeleteButton,
            this.Content1,
            this.Content2,
            this.Content3});
            this.dataGridViewContents.Location = new System.Drawing.Point(13, 13);
            this.dataGridViewContents.Name = "dataGridViewContents";
            this.dataGridViewContents.RowTemplate.Height = 21;
            this.dataGridViewContents.Size = new System.Drawing.Size(750, 243);
            this.dataGridViewContents.TabIndex = 0;
            this.dataGridViewContents.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridViewContents_CellContentClick);
            // 
            // DeleteButton
            // 
            this.DeleteButton.HeaderText = "削除";
            this.DeleteButton.Name = "DeleteButton";
            this.DeleteButton.Text = "削除";
            // 
            // Content1
            // 
            this.Content1.HeaderText = "内容1";
            this.Content1.Name = "Content1";
            this.Content1.ToolTipText = "内容1";
            this.Content1.Width = 200;
            // 
            // Content2
            // 
            this.Content2.HeaderText = "内容2";
            this.Content2.Name = "Content2";
            this.Content2.ToolTipText = "内容2";
            // 
            // Content3
            // 
            this.Content3.HeaderText = "内容3";
            this.Content3.Name = "Content3";
            this.Content3.ToolTipText = "内容3";
            // 
            // buttonOK
            // 
            this.buttonOK.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.buttonOK.Location = new System.Drawing.Point(309, 275);
            this.buttonOK.Name = "buttonOK";
            this.buttonOK.Size = new System.Drawing.Size(75, 23);
            this.buttonOK.TabIndex = 1;
            this.buttonOK.Text = "OK";
            this.buttonOK.UseVisualStyleBackColor = true;
            this.buttonOK.Click += new System.EventHandler(this.buttonOK_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonCancel.Location = new System.Drawing.Point(390, 275);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(75, 23);
            this.buttonCancel.TabIndex = 2;
            this.buttonCancel.Text = "キャンセル";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // FormEdit
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(775, 331);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonOK);
            this.Controls.Add(this.dataGridViewContents);
            this.Name = "FormEdit";
            this.Text = "予告の追加・編集・削除";
            this.Load += new System.EventHandler(this.FormEdit_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewContents)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridViewContents;
        private System.Windows.Forms.DataGridViewButtonColumn DeleteButton;
        private System.Windows.Forms.DataGridViewTextBoxColumn Content1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Content2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Content3;
        private System.Windows.Forms.Button buttonOK;
        private System.Windows.Forms.Button buttonCancel;
    }
}