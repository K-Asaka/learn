using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MySample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int age;
            age = 23;
            Console.WriteLine(age);
            Console.WriteLine("年齢：{0}", age);
            Console.WriteLine("年齢は{0}歳です", age);
            int number = 8;
            Console.WriteLine("{0}歳の人は{1}人います", age, number);

            string name;
            name = "山田";
            Console.WriteLine("{0}さん、こんにちは", name);
            Console.WriteLine("{0}さん、お久しぶりです", name);
        }
    }
}
