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
            var num = 15;
            if (num % 3 == 0 || num % 5 == 0)
            {
                    Console.WriteLine("numは3か5で割り切れます");
            }
        }
    }
}
