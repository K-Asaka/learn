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

            string name = "山田";
            Console.WriteLine("{0}さん、こんにちは", name);
            name = "佐藤";
            Console.WriteLine("{0}さん、お久しぶりです", name);

            int height = 8;
            int width = 5;
            int area;
            area = height * width;
            Console.WriteLine("面積：{0}㎡", area);

            var age2 = 19;
            var name2 = "近藤";
            Console.WriteLine("age2：{0}, name2：{1}", age2, name2);

            Console.WriteLine("名前を入力してください。");
            var name3 = Console.ReadLine();
            Console.WriteLine("{0}さん、おはようございます", name3);
        }
    }
}
