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
            var line = Console.ReadLine();
            var num = int.Parse(line);
            if (num % 2 == 0)
            {
                Console.WriteLine("偶数です");
            }
            else
            {
                Console.WriteLine("奇数です");
            }
        }
    }
}
