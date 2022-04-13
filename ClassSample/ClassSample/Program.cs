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
            int? number = 123;
            if (number == null)
            {
                Console.WriteLine("numberはnullです");
            }
            else
            {
                int n = number.Value;
                Console.WriteLine($"number={n}");
            }
        }
    }
}