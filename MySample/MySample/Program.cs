using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MySample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("おはよう\nこんにちは\nこんばんは");

            var message = "おはようございます";
            var length = message.Length;
            Console.WriteLine("{0}文字", length);

            var emptyString = "";
            Console.WriteLine("1行目");
            Console.WriteLine(emptyString);
            Console.WriteLine("3行目");
        }
    }
}
