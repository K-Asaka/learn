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
            var abs1 = Math.Abs(150);
            var abs2 = Math.Abs(-320);
            var abs3 = Math.Abs(-5.67M);
            var abs4 = Math.Abs(-1.414);
            Console.WriteLine(abs1);
            Console.WriteLine(abs2);
            Console.WriteLine(abs3);
            Console.WriteLine(abs4);
        }
    }
}