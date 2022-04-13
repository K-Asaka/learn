using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var nums = new List<int> { 4, 6, 7, 1, 3, 9, 2, 1, 5, 8 };
            var query = nums.OrderByDescending(x => x)
                            .Take(3);
            foreach (var n in query)
            {
                Console.WriteLine(n);
            }
        }
    }
} 