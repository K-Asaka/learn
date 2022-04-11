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
            var scores = new int[] { 65, 54, 78, 96, 81 };
            var total = 0;
            for (var i = 0; i < 5; i++)
            {
                total += scores[i];
            }
            var average = (double)total / 5;
            Console.WriteLine("平均点: {0}", average);
        }
    }
}
