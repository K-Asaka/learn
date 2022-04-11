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
            var array2d = new int[,]
            {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 10, 11, 12 }
            };
            for (var row = 0; row < 4; row++)
            {
                for (var col = 0; col < 3; col++)
                {
                    Console.Write("{0} ", array2d[row, col]);
                }
                Console.WriteLine();
            }
        }
    }
}
