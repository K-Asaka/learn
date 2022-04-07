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
            for (var x = 1; x <= 9; x++)
            {
                for (var y = 1; y <= 9; y++)
                {
                    var n = x * y;
                    Console.WriteLine($"{x} × {y} = {n}");
                }
            }
        }
    }
}
