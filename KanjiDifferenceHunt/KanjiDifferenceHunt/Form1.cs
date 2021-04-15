using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace KanjiDifferenceHunt
{
    public partial class FormGame : Form
    {
        string correctText = "荻";       // 正解の文字：1つだけ
        string mistakeText = "萩";       // 間違いの文字：24個並ぶ
        double nowTime;                  // 経過時間

        public FormGame()
        {
            InitializeComponent();
        }
        
        // スタートボタンをクリックしたとき
        private void buttonStart_Click(object sender, EventArgs e)
        {
            textHunt.Text = correctText;            // 探す文字を表示
            Random rnd = new Random();              // 乱数を生成するためのインスタンスを生成
            int randomResult = rnd.Next(25);        // 0～24の乱数を取得

            // splitContainerの下部のPanel2に乗っている
            // ButtonのTextをすべて間違いの文字にする
            for (int i = 0; i < splitContainer1.Panel2.Controls.Count; i++)
            {
                splitContainer1.Panel2.Controls[i].Text = mistakeText;
            }

            // ランダムで1つだけ正解の文字にする
            splitContainer1.Panel2.Controls[randomResult].Text = correctText;

            // タイマースタート
            nowTime = 0;        // タイマーの初期化
            timer1.Start();
        }

        // 0.2秒置きに呼ばれるタイマーのイベントハンドラ
        private void timer1_Tick(object sender, EventArgs e)
        {
            nowTime = nowTime + 0.02;
            textTimer.Text = nowTime.ToString("0.00");
        }

        private void buttons_Click(object sender, EventArgs e)
        {
            if (((Button)sender).Text == correctText)
            {
                timer1.Stop();      // 時間の計測終了
            }
            else
            {
                nowTime = nowTime + 10;     // ペナルティー
            }
        }
    }
}
