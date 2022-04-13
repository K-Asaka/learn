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
            var query = words.Where(x => x.Length == 6);
            foreach (var word in query)
            {
                Console.WriteLine(word);
            }
        }
    }
}