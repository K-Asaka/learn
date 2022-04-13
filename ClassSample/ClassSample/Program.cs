using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var nums = new List<int> { 12, 56, 75, 8, 12, 95, 32, 85, 24, 49 };

            var query = nums.Where(x => x >= 50);
            foreach (var n in query)
            {
                Console.WriteLine(n);
            }
        }
    }
}