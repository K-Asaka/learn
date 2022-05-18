using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StringCharsExample();
        }

        static void StringCharsExample()
        {
            string str = "ABC";
            char c = str[1];        // c = 'B'
            Console.WriteLine(c);
        }
    }
}
