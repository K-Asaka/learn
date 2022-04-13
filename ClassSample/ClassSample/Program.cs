using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var index = 36;
            var s1 = index.ToString();
            var height = 98.7M;
            var s2 = height.ToString();
            var date = new DateTime(2020, 8, 24);
            var s3 = date.ToString();
            Console.WriteLine($"{s1} | {s2} | {s3}");
        }
    }
}