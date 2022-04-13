using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var nums = new List<int> { 4, 6, 7, 1, 3, 9, 2, 5, 8 };
            var query = nums.OrderBy(x => x);
            foreach (var n in query)
            {
                Console.WriteLine(n);
            }
        }
    }
} 