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
            var str = "オブジェクト指向";
            var sub1 = str.Substring(0, 6);
            var sub2 = str.Substring(6, 2);
            Console.WriteLine(str);
            Console.WriteLine(sub1);
            Console.WriteLine(sub2);
        }
    }
}
