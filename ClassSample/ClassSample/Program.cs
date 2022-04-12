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
            var week = DayOfWeek.Sunday; 
            if (week == DayOfWeek.Friday)
            {
                Console.WriteLine("金曜日です");
            }
            else
            {
                Console.WriteLine("金曜日ではありません");
            }
        }
    }
}