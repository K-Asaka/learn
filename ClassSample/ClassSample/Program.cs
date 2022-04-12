using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var r1 = Math.Round(6.4, MidpointRounding.AwayFromZero);
            var r2 = Math.Round(6.4);
            Console.WriteLine($"{r1}, {r2}");
            var r3 = Math.Round(6.5, MidpointRounding.AwayFromZero);
            var r4 = Math.Round(6.5);
            Console.WriteLine($"{r3}, {r4}");
            var r5 = Math.Round(6.6, MidpointRounding.AwayFromZero);
            var r6 = Math.Round(6.6);
            Console.WriteLine($"{r5}, {r6}");
        }
    }
}