using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Uranai
{
    public partial class FormUranai : Form
    {
        public FormUranai()
        {
            InitializeComponent();
        }

        private void buttonUranaiStart_Click(object sender, EventArgs e)
        {
            int dateNumber;     // 年間累積日を記憶する変数
            dateNumber = dateTimeUranai.Value.DayOfYear;        // 選んだ日付から、年間累積日を計算

            switch (dateNumber % 5)     // 年間累積日を5で割った余りは？
            {
                case 0:     // 大吉
                    pictureBoxResult.Image = Uranai.Properties.Resources.Daikichi;
                    textResult.Text = "思ったことがコードにかけてものすごいアプリがつくれるかも！！";
                    break;
                case 1:     // 中吉
                    pictureBoxResult.Image = Uranai.Properties.Resources.Cyuukichi;
                    textResult.Text = "書いたコードがビルドエラーも起きず一発で実行できるかも！";
                    break;
                case 2:     // 小吉
                    pictureBoxResult.Image = Uranai.Properties.Resources.Syoukichi;
                    textResult.Text = "できた！と思ったらコード書き忘れて動かないところがあるかも";
                    break;
                case 3:     // 吉
                    pictureBoxResult.Image = Uranai.Properties.Resources.Kichi;
                    textResult.Text = "なかなかエラーが修正できないかも";
                    break;
                case 4:     // 凶
                    pictureBoxResult.Image = Uranai.Properties.Resources.Kyou;
                    textResult.Text = "せっかく書いたプログラムが消えるかも。"
                        + "まさにしょぼーんなことがおこるかも";
                    break;
                default:    // ここに到達することがあれば条件のミス
                    pictureBoxResult.Image = null;
                    break;
            }
        }
    }
}
