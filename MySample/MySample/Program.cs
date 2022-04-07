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
            var num = 0;
            while (num <= 0 || 5 <= num)
            {
                Console.WriteLine("1、2、3、4のいずれかを入力してください。");
                var line = Console.ReadLine();
                num = int.Parse(line);
            }
            Console.WriteLine($"{num}が入力されました。");
        }
    }
}
