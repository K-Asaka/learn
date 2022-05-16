using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int a = 10;
            string s = "こんにちは";
            Console.WriteLine("{0}、aの値は{1}です。", s, a);
            Console.WriteLine($"{s}、aの値は{a}です。");
        }
    }
}
