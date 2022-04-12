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
            // 1⃣配列の要素を0、10、20、30、40……に設定する
            var array = new int[10];
            ArrayUtils.SetValue(array, 0, 10);
            // 2⃣配列のすべての要素を1に設定する
            var array2 = new int[10];
            ArrayUtils.SetValue(array2, 1);
            // 3⃣配列のすべての要素を0に設定する
            var array3 = new int[10];
            ArrayUtils.SetValue(array3);

            foreach (var v in array)
            {
                Console.WriteLine(v);
            }
            foreach (var v in array2)
            {
                Console.WriteLine(v);
            }
            foreach (var v in array3)
            {
                Console.WriteLine(v);
            }
        }
    }
    static class ArrayUtils
    {
        public static void SetValue(int[] array, int value = 0, int inc = 0)
        {
            for (var i = 0; i < array.Length; i++)
            {
                array[i] = value;
                value += inc;
            }
        }
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