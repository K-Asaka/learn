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
            for (var i = 0; i < args.Length; i++)
            {
                var s = args[i];
                Console.WriteLine($"{i}番目の引数は、{s}です");
            }
        }
    }
}
