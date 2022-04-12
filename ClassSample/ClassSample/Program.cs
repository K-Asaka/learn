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
            var str = "銀河鉄道の夜,宮沢賢治";
            var items = str.Split(',');
            Console.WriteLine("Title: {0}", items[0]);
            Console.WriteLine("Author: {0}", items[1]);
        }
    }
}