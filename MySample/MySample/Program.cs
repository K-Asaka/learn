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
            var price1 = 1100;
            var price2 = 800;
            var price3 = 1250;
            var total = price1 + price2 + price3;
            Console.WriteLine("合計：{0}円", total);

            var member = 4;
            var perPerson = total / member;
            Console.WriteLine("1人当たり：{0}円", perPerson);

            var remainder = total % member;
            Console.WriteLine("余り：{0}", remainder);
        }
    }
}
