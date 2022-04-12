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
            var nums = ArrayUtils.GetArray(5);
            // nums配列内の要素の合計を求める
            var total = 0;
            foreach (var x in nums)
            {
                total += x;
            }
            Console.WriteLine($"合計: {total}");
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

        public static int[] GetArray(int count)
        {
            var array = new int[count];
            for (var i = 0; i < count; i++)
            {
                var line = Console.ReadLine();
                array[i] = int.Parse(line);
            }
            return array;
        }
    }
}