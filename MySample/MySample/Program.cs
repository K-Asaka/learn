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
            for (var year = 1; year <= 64; year++)
            {
                var westernYear = year + 1925;
                Console.WriteLine($"昭和{year}年 {westernYear}年");
            }
        }
    }
}
