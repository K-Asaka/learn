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
            var average = 3.28m;
            Console.WriteLine(average);

            var price = 1280m;
            var priceIncludingTax = price * 1.08m;
            Console.WriteLine(priceIncludingTax);
        }
    }
}
