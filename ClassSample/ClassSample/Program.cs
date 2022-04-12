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
            var now = DateTime.Now;
            Console.WriteLine("{0}年", now.Year);
            Console.WriteLine("{0}月", now.Month);
            Console.WriteLine("{0}日", now.Day);
            Console.WriteLine("{0}時", now.Hour);
            Console.WriteLine("{0}分", now.Minute);
            Console.WriteLine("{0}秒", now.Second);
        }
    }
}