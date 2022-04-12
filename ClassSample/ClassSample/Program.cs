using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var str = "ようこそ、C#の世界へ";
            var length = str.Length;
            Console.WriteLine($"{length}文字です");
        }
    }
}
