namespace AlarmTimer
{
    partial class FormSet
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
            this.radioButtonAlarm = new System.Windows.Forms.RadioButton();
            this.radioButtonTimer = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.numericUpDownAlmHour = new System.Windows.Forms.NumericUpDown();
            this.numericUpDownAlmMnt = new System.Windows.Forms.NumericUpDown();
            this.numericUpDownTimMnt = new System.Windows.Forms.NumericUpDown();
            this.numericUpDownTimSec = new System.Windows.Forms.NumericUpDown();
            this.buttonOK = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownAlmHour)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownAlmMnt)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownTimMnt)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownTimSec)).BeginInit();
            this.SuspendLayout();
            // 
            // radioButtonAlarm
            // 
            this.radioButtonAlarm.AutoSize = true;
            this.radioButtonAlarm.ForeColor = System.Drawing.Color.White;
            this.radioButtonAlarm.Location = new System.Drawing.Point(13, 13);
            this.radioButtonAlarm.Name = "radioButtonAlarm";
            this.radioButtonAlarm.Size = new System.Drawing.Size(60, 16);
            this.radioButtonAlarm.TabIndex = 0;
            this.radioButtonAlarm.TabStop = true;
            this.radioButtonAlarm.Text = "アラーム";
            this.radioButtonAlarm.UseVisualStyleBackColor = true;
            // 
            // radioButtonTimer
            // 
            this.radioButtonTimer.AutoSize = true;
            this.radioButtonTimer.ForeColor = System.Drawing.Color.White;
            this.radioButtonTimer.Location = new System.Drawing.Point(127, 12);
            this.radioButtonTimer.Name = "radioButtonTimer";
            this.radioButtonTimer.Size = new System.Drawing.Size(59, 16);
            this.radioButtonTimer.TabIndex = 1;
            this.radioButtonTimer.TabStop = true;
            this.radioButtonTimer.Text = "タイマー";
            this.radioButtonTimer.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(13, 36);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(17, 12);
            this.label1.TabIndex = 2;
            this.label1.Text = "時";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(192, 36);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(17, 12);
            this.label2.TabIndex = 3;
            this.label2.Text = "分";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(13, 68);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(17, 12);
            this.label3.TabIndex = 4;
            this.label3.Text = "分";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(192, 68);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(29, 12);
            this.label4.TabIndex = 5;
            this.label4.Text = "秒後";
            // 
            // numericUpDownAlmHour
            // 
            this.numericUpDownAlmHour.Location = new System.Drawing.Point(36, 34);
            this.numericUpDownAlmHour.Maximum = new decimal(new int[] {
            23,
            0,
            0,
            0});
            this.numericUpDownAlmHour.Name = "numericUpDownAlmHour";
            this.numericUpDownAlmHour.Size = new System.Drawing.Size(59, 19);
            this.numericUpDownAlmHour.TabIndex = 6;
            this.numericUpDownAlmHour.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.numericUpDownAlmHour.ValueChanged += new System.EventHandler(this.NumericUpDownAlm_ValueChanged);
            // 
            // numericUpDownAlmMnt
            // 
            this.numericUpDownAlmMnt.Location = new System.Drawing.Point(36, 66);
            this.numericUpDownAlmMnt.Maximum = new decimal(new int[] {
            59,
            0,
            0,
            0});
            this.numericUpDownAlmMnt.Name = "numericUpDownAlmMnt";
            this.numericUpDownAlmMnt.Size = new System.Drawing.Size(59, 19);
            this.numericUpDownAlmMnt.TabIndex = 6;
            this.numericUpDownAlmMnt.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.numericUpDownAlmMnt.Value = new decimal(new int[] {
            59,
            0,
            0,
            0});
            this.numericUpDownAlmMnt.ValueChanged += new System.EventHandler(this.NumericUpDownAlm_ValueChanged);
            // 
            // numericUpDownTimMnt
            // 
            this.numericUpDownTimMnt.Location = new System.Drawing.Point(127, 34);
            this.numericUpDownTimMnt.Maximum = new decimal(new int[] {
            59,
            0,
            0,
            0});
            this.numericUpDownTimMnt.Name = "numericUpDownTimMnt";
            this.numericUpDownTimMnt.Size = new System.Drawing.Size(59, 19);
            this.numericUpDownTimMnt.TabIndex = 6;
            this.numericUpDownTimMnt.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.numericUpDownTimMnt.Value = new decimal(new int[] {
            59,
            0,
            0,
            0});
            this.numericUpDownTimMnt.ValueChanged += new System.EventHandler(this.NumericUpDownTim_ValueChanged);
            // 
            // numericUpDownTimSec
            // 
            this.numericUpDownTimSec.Location = new System.Drawing.Point(127, 66);
            this.numericUpDownTimSec.Maximum = new decimal(new int[] {
            59,
            0,
            0,
            0});
            this.numericUpDownTimSec.Name = "numericUpDownTimSec";
            this.numericUpDownTimSec.Size = new System.Drawing.Size(59, 19);
            this.numericUpDownTimSec.TabIndex = 6;
            this.numericUpDownTimSec.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.numericUpDownTimSec.Value = new decimal(new int[] {
            59,
            0,
            0,
            0});
            this.numericUpDownTimSec.ValueChanged += new System.EventHandler(this.NumericUpDownTim_ValueChanged);
            // 
            // buttonOK
            // 
            this.buttonOK.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.buttonOK.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonOK.ForeColor = System.Drawing.Color.White;
            this.buttonOK.Location = new System.Drawing.Point(36, 105);
            this.buttonOK.Name = "buttonOK";
            this.buttonOK.Size = new System.Drawing.Size(75, 23);
            this.buttonOK.TabIndex = 7;
            this.buttonOK.Text = "OK";
            this.buttonOK.UseVisualStyleBackColor = true;
            this.buttonOK.Click += new System.EventHandler(this.buttonOK_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonCancel.ForeColor = System.Drawing.Color.White;
            this.buttonCancel.Location = new System.Drawing.Point(127, 105);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(75, 23);
            this.buttonCancel.TabIndex = 8;
            this.buttonCancel.Text = "キャンセル";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // FormSet
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.MediumBlue;
            this.ClientSize = new System.Drawing.Size(236, 151);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonOK);
            this.Controls.Add(this.numericUpDownTimSec);
            this.Controls.Add(this.numericUpDownTimMnt);
            this.Controls.Add(this.numericUpDownAlmMnt);
            this.Controls.Add(this.numericUpDownAlmHour);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.radioButtonTimer);
            this.Controls.Add(this.radioButtonAlarm);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FormSet";
            this.Text = "設定";
            this.Load += new System.EventHandler(this.FormSet_Load);
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownAlmHour)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownAlmMnt)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownTimMnt)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownTimSec)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton radioButtonAlarm;
        private System.Windows.Forms.RadioButton radioButtonTimer;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.NumericUpDown numericUpDownAlmHour;
        private System.Windows.Forms.NumericUpDown numericUpDownAlmMnt;
        private System.Windows.Forms.NumericUpDown numericUpDownTimMnt;
        private System.Windows.Forms.NumericUpDown numericUpDownTimSec;
        private System.Windows.Forms.Button buttonOK;
        private System.Windows.Forms.Button buttonCancel;
    }
}