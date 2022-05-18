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
            StringLengthExample();
        }

        static void StringCharsExample()
        {
            string str = "ABC";
            char c = str[1];        // c = 'B'
            Console.WriteLine(c);
        }

        static void StringLengthExample()
        {
            string str = "ABC", str2 = "あいうえお";
            int length1 = str.Length;       // length1 = 3
            int length2 = str2.Length;      // length2 = 5(全角文字も1字と数える)
            Console.WriteLine("length1 = " + length1);
            Console.WriteLine("length2 = " + length2);
        }
    }
}
