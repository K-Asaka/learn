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
            var str = "　オブジェクト指向  ";
            var str2 = str.Trim();
            Console.WriteLine($"[{str}]");
            Console.WriteLine($"[{str2}]");
        }
    }
}
