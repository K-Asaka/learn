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
            var n = 3.7;
            var floor = Math.Floor(n);
            var ceiling = Math.Ceiling(n);
            Console.WriteLine($"{floor}, {ceiling}");
        }
    }
}