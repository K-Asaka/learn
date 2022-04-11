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
            for (var i = 0; i < 50; i++)
            {
                if (i % 13 != 0)
                {
                    continue;
                }
                Console.WriteLine($"{i}は13で割り切れる数です");
            }
        }
    }
}
