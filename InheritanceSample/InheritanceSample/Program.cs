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

            Class2 c2 = new Class2("旧姓");
            Console.WriteLine(c2.Name);         // "旧姓"を出力

            //c2.name = "新しい姓";
            c2.NameChange("結婚後の姓");
            Console.WriteLine(c2.Name);         // "結婚後の姓"を出力
        }
    }

    class Class1
    {
        protected string name;          // 派生クラスからはアクセス可能

        public Class1(string n)
        {
            name = n;
        }

        public string Name
        {
            get { return name; }
        }
    }

    class Class2 : Class1
    {
        public Class2(string n) : base(n) { }

        public void NameChange(string n)
        {
            base.name = n;      // 基本クラスのnameはprotectedなのでアクセス可能
        }
    }
}
