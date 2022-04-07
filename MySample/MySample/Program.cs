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
            var temperature = 29.5;

            if (temperature >= 35.0)
            {
                Console.WriteLine("猛暑日です");
            }
            else if (temperature >= 30.0)
            {
                Console.WriteLine("真夏日です");
            }
            else if (temperature >= 25.0)
            {
                Console.WriteLine("夏日です");
            }
            else
            {
                Console.WriteLine("いずれでもありません");
            }
        }
    }
}
