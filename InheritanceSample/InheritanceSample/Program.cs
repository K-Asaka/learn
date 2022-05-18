using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InheritanceSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Television tv = new Television();

            Console.Write($"電源:{(tv.Power ? "ON" : "OFF")}");
            Console.WriteLine($"チャンネル：{tv.Channel} 音量：{tv.Volume}");

            Console.WriteLine("電源ボタンを押します。");
            tv.OnOff();
            Console.WriteLine($"電源：{(tv.Power ? "ON" : "OFF")}");

            Console.WriteLine("電源ボタンを押します。");
            tv.OnOff();
            Console.WriteLine($"電源：{(tv.Power ? "ON" : "OFF")}");

            Class1 c1 = new Class1();
            Class2 c2 = new Class2();

            c1.M();
            Console.WriteLine("c1.x = " + c1.x);
            c2.M();
            Console.WriteLine("c2.x = " + c2.x);
        }
    }

    class Class1
    {
        public int x = 10;

        public void M()
        {
            Console.WriteLine("基本クラスのメソッドが呼ばれました。");
        }
    }

    class Class2 : Class1
    {
        public new int x = 20;          // 基本クラスの変数xを隠蔽

        public new void M()             // 基本クラスのMメソッドを隠蔽
        {
            Console.WriteLine("派生クラスのメソッドが呼ばれました。");
        }
    }
}
