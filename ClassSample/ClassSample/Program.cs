using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            PrintEvenOrOdd(6);
            PrintEvenOrOdd(25);
        }

        static void Print()
        {
            var num = 123;
            Console.WriteLine(num);
        }

        static void PrintEvenOrOdd(int num)
        {
            string str;
            if (num % 2 == 0)
            {
                str = "偶数";
            }
            else
            {
                str = "奇数";
            }
            Console.WriteLine($"{num}は{str}");
        }
    }
}
