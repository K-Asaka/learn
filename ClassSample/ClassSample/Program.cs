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
            var scores = new int[] { 55, 60, 45, 70, 85, 93, 68 };
            var total = ArrayUtils.Total(scores);
            var average = ArrayUtils.Average(scores);
            Console.WriteLine($"合計:{total}, 平均:{average}");
        }
    }
    static class ArrayUtils
    {
        // 配列内の数値の合計を求める
        public static int Total(int[] numbers)
        {
            var total = 0;
            foreach (var n in numbers)
            {
                total += n;
            }
            return total;
        }

        // 配列内の数値の平均を求める
        public static double Average(int[] numbers)
        {
            var total = Total(numbers);
            return (double)total / numbers.Length;
        }
    }
}
