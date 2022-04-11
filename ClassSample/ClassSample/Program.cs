using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var array = new int[] { 5, 8, 4, 9, 5, -3, 6 };
            var foundIndex = -1;
            for (var i = 0; i < array.Length; i++)
            {
                if (array[i] < 0)
                {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex >= 0)
            {
                Console.WriteLine($"配列最初のマイナス値は {array[foundIndex]}です。");
            }
            else
            {
                Console.WriteLine("配列にマイナス値はありませんでした。");
            }
        }
    }
}
