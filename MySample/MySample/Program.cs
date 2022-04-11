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
            for (var i = 0; i < 10; i++)
            {
                var x = 0;
                while (x < 20)
                {
                    if (x == 5)
                    {
                        break;
                    }
                    x++;
                }
                Console.WriteLine($"whileループ終了 i={i} x={x}");
                if (i == 3)
                {
                    break;
                }
            }
            Console.WriteLine("forループ終了");
        }
    }
}
