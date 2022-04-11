using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var num = 10;
            Console.WriteLine(num);
            Print();
            Console.WriteLine(num);
        }

        static void Print()
        {
            var num = 123;
            Console.WriteLine(num);
        }
    }
}
