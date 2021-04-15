using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SlackPost
{
    public partial class FormSlackPost : Form
    {
        public FormSlackPost()
        {
            InitializeComponent();
        }

        private void butPost_Click(object sender, EventArgs e)
        {
            // Webhook URLは、各自で取得した値を利用してください。
            string strWebHookUrl = "xxxx";

            string strData = string.Format("{{'text':'{0}'}}", txtPost.Text);

            System.Net.WebClient client = new System.Net.WebClient();
            client.Headers.Add(System.Net.HttpRequestHeader.ContentType, "application/json;charset=UTF-8");
            client.Encoding = Encoding.UTF8;

            string reply = client.UploadString(strWebHookUrl, strData);

            MessageBox.Show(reply);
        }
    }
}
