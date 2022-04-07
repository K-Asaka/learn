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
            var line = Console.ReadLine();
            var num = int.Parse(line);
            if (num >= 10)
            {
                Console.WriteLine("num >= 10が成り立ちました。");
                Console.WriteLine($"numの値は{num}です。");
            }

            var lang = Console.ReadLine();
            if (lang == "C#")
            {
                Console.WriteLine("langの値は「C#」です。");
            }
            if (lang != "Java")
            {
                Console.WriteLine("langの値は「Java」ではありません。");
            }
        }
    }
}
