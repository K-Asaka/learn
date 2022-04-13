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
            var query = words.Select(x => x.Length);
            foreach (var length in query)
            {
                Console.WriteLine(length);
            }
        }
    }
}