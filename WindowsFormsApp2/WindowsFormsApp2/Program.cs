using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    internal static class Program
    {
        /// <summary>
        /// アプリケーションのメイン エントリ ポイントです。
        /// </summary>
        [STAThread]
        static void Main()
        {
            DateTimePropertyExample();
            DateTimeAddExample();
            DateTimeToXxxxXxxxStringExample();
            DateTimeToStringExample();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }

        static void DateTimePropertyExample()
        {
            Console.WriteLine("今日の日付：" + DateTime.Today);
            Console.WriteLine("現在の日付と日時：" + DateTime.Now);

            // 現在の日付と日時を取得する
            DateTime now = DateTime.Now;

            Console.WriteLine("年 = " + now.Year);
            Console.WriteLine("月 = " + now.Month);
            Console.WriteLine("日 = " + now.Day);
            Console.WriteLine("時 = " + now.Hour);
            Console.WriteLine("分 = " + now.Minute);
            Console.WriteLine("秒 = " + now.Second);
            Console.WriteLine("曜日 = " + now.DayOfWeek);
        }

        static void DateTimeAddExample()
        {
            DateTime now = DateTime.Now;                    // 現在の日時を得る
            Console.WriteLine(now);                         // 現在日時の表示
            TimeSpan addSpan = new TimeSpan(10, 10, 10);    // TimeSpan(時, 分, 秒)
            DateTime answer = now.Add(addSpan);             // TimeSpanの加算
            Console.WriteLine(answer);
            addSpan = new TimeSpan(1, 1, 1, 1);             // TimeSpan(日, 時, 分, 秒)
            answer = now.Add(addSpan);                      // TimeSpanの加算
            Console.WriteLine(answer);
        }

        static void DateTimeToXxxxXxxxStringExample()
        {
            DateTime now = DateTime.Now;
            Console.WriteLine(now);
            Console.WriteLine(now.ToLongDateString());
            Console.WriteLine(now.ToLongTimeString());
            Console.WriteLine(now.ToShortDateString());
            Console.WriteLine(now.ToShortTimeString());
        }

        static void DateTimeToStringExample()
        {
            DateTime now = DateTime.Now;
            Console.WriteLine(now.ToString());
            Console.WriteLine("D = " + now.ToString("D"));
            Console.WriteLine("T = " + now.ToString("T"));
            Console.WriteLine("d = " + now.ToString("d"));
            Console.WriteLine("t = " + now.ToString("t"));
            Console.WriteLine("m = " + now.ToString("m"));
        }
    }
}
