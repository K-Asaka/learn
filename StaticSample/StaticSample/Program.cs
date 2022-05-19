using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StaticSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine($"合格点は{Class1.PassScore}点です。");

            Class1 c1 = new Class1("青森一郎", 60);
            Class1 c2 = new Class1("岩手二郎", 70);
            Class1 c3 = new Class1("秋田三郎", 80);

            Console.WriteLine($"合格点は{Class1.PassScore}点です。");
            Console.WriteLine($"{c1.Name}は{c1.Score}点です。");
            Console.WriteLine($"{c2.Name}は{c2.Score}点です。");
            Console.WriteLine($"{c3.Name}は{c3.Score}点です。");
            Class1.PassScore += 10;

            Console.WriteLine($"合格点は{Class1.PassScore}点に上がりました。");

            PIExample();
            PowExample();
            SqrtExample();
            SinCosTanExample();
        }

        static void PIExample()
        {
            double r = 3.4;
            double s = r * r * Math.PI;     // 円の面積 s = 36.316811075498
            Console.WriteLine(s);
        }

        static void PowExample()
        {
            double x = Math.Pow(2.0, 10.0);     // 2の10乗 x = 1024
            Console.WriteLine(x);
        }

        static void SqrtExample()
        {
            double x = Math.Sqrt(2.0);      // 2の平方根 x = 1.4142135623731
            Console.WriteLine(x);
        }

        static void SinCosTanExample()
        {
            double angle = 30;
            double radians = angle * (Math.PI / 180);
            double sin = Math.Sin(radians);     // sin = 0.5
            double cos = Math.Cos(radians);     // cos = 0.866025403784439
            double tan = Math.Tan(radians);     // tan = 0.577350269189626
            Console.WriteLine(sin);
            Console.WriteLine(cos);
            Console.WriteLine(tan);
        }
    }

    class Class1
    {
        public string Name;
        public int Score;
        public static int PassScore = 50;

        public Class1(string name, int score)
        {
            this.Name = name;
            this.Score = score;
            PassScore = 60;
        }
    }
}
