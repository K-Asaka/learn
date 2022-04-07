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
            Console.Write("x=");
            var xline = Console.ReadLine();
            Console.Write("y=");
            var yline = Console.ReadLine();
            var x = int.Parse(xline);
            var y = int.Parse(yline);
            if (x == 0)
            {
                Console.WriteLine("xは0です");
                if (y == 0)
                {
                    Console.WriteLine("yも0です");
                }
            }

        }
    }
}
