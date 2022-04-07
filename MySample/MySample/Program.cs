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
            var total = 100;
            var line = Console.ReadLine();
            var count = int.Parse(line);
            var num = total / count;
            Console.WriteLine(num);
        }
    }
}
