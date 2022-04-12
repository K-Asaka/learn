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
            var date = new DateTime(2019, 4, 3, 19, 8, 53);
            var s5 = date.ToString("yyyy年MM月dd日(ddd) HH時mm分ss秒");
            var s6 = date.ToString("yy年M月d日(ddd) H時m分s秒");
            var s7 = date.ToString("yy年M月d日(ddd) tth時m分s秒");
            var s8 = date.ToString("yyyy/MM/dd HH:mm");
            var s9 = date.ToString("yy/M/d H:m");
            Console.WriteLine(s5);
            Console.WriteLine(s6);
            Console.WriteLine(s7);
            Console.WriteLine(s8);
            Console.WriteLine(s9);
        }
    }
}