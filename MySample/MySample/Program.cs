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
            var season = '夏';
            var temperature = 39;
            var str = $"今年の{season}の最高気温は、{temperature}度でした。";
            Console.WriteLine(str);

            Console.WriteLine($"今年の{season}の最高気温は、{temperature}度でした。");
        }
    }
}
