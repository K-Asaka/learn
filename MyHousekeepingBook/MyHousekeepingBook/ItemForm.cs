using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyHousekeepingBook
{
    public partial class ItemForm : Form
    {
        public ItemForm(CategoryDataSet dsCategory)
        {
            InitializeComponent();
            categoryDataSet.Merge(dsCategory);
        }

        public ItemForm(CategoryDataSet dsCategory,     // 第1引数、分類一覧(型付きデータセット型)
            DateTime nowDate,                           // 第2引数、日付(日付型)
            string category,                            // 第3引数、分類(文字列型)
            string item,                                // 第4引数、品名(文字列型)
            int money,                                  // 第5引数、金額(整数型)
            string remarks)                             // 第6引数、備考(文字列型)
        {
            InitializeComponent();                      // 初期化処理
            categoryDataSet.Merge(dsCategory);
            monCalendar.SetDate(nowDate);
            cmbCategory.Text = category;
            txtItem.Text = item;
            mtxtMoney.Text = money.ToString();
            txtRemarks.Text = remarks;
        }

        private ItemForm()
        {
            // 引数なしのコンストラクタは使用しない
        }
    }
}
