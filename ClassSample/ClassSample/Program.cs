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
            var lines = File.ReadAllLines(@"C:\temp\祇園精舎.txt");
            foreach (var line in lines)
            {
                Console.WriteLine(line);
            }
        }
    }
}