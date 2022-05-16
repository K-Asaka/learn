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
            int n, div = 1000;

            Console.WriteLine("整数値を5回入力してください。");
            for (int i = 1; i <= 5; i++)
            {
                Console.Write("＞ ");
                n = int.Parse(Console.ReadLine());
                if (n == 0)
                {
                    Console.WriteLine("0では割れません。再入力してください。");
                    continue;
                }
                Console.WriteLine($"{div} / {n} = ");
                div /= n;
                Console.WriteLine(div);
            }
        }
    }
}
