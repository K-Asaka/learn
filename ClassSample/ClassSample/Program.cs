using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            var query = nums.Select(x => x * 2);
            foreach (var n in query)
            {
                Console.WriteLine(n);
            }
        }
    }
}