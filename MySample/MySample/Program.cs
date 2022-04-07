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
            var source = 15.8;
            var width = (int)source;
            Console.WriteLine(width);

            var total = 998;
            var discount = total * 0.1;
            var payment = total - discount;

            Console.WriteLine("割引額：{0}円", discount);
            Console.WriteLine("支払額：{0}円", payment);
        }
    }
}
