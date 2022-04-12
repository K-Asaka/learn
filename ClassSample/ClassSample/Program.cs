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
            var value1 = 340;
            var value2 = 500;
            var max = Math.Min(value1, value2);
            Console.WriteLine(max);
        }
    }
}