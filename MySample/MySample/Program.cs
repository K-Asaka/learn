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
            for (var i = 0; i < 20; i++)
            {
                var s = Console.ReadLine();
                if (s == "")
                {
                    break;
                }
                Console.WriteLine(s);
            }
            Console.WriteLine("ループを終了しました");
        }
    }
}
