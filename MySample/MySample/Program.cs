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
            var month = 6;
            if (1 <= month && month <= 12)
            {
                    Console.WriteLine("1以上、12以下の数値です");
            }
        }
    }
}
