using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var scores = new int[] { 55, 60, 45, 70, 85, 93, 68 };
            var total = ArrayUtils.Total(scores);
            Console.WriteLine(total);

            var scores2 = new double[] { 5.9, 9.6, 12.4, 8.0, 7.9 };
            var total2 = ArrayUtils.Total(scores2);
            Console.WriteLine(total2);
        }
    }
    static class ArrayUtils
    {
        // 1⃣int型の配列内の数値の合計を求める
        public static int Total(int[] numbers)
        {
            var total = 0;
            foreach (var n in numbers)
            {
                total += n;
            }
            return total;
        }
        // 2⃣double型の配列内の数値の合計を求める
        public static double Total(double[] numbers)
        {
            var total = 0.0;
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