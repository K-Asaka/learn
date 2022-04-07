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
            var line = "";
            do
            {
                Console.WriteLine("何か入力してください");
                line = Console.ReadLine();
            } while (line == "");
            Console.WriteLine(line);
        }
    }
}
