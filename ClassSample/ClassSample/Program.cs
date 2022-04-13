using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var words = new List<string>
            {
                "effect", "access", "condition", "sign", "profit", "line", "result"
            };
            var array = words.OrderBy(x => x)
                             .ToArray();
            Console.WriteLine(array[0]);
        }
    }
} 