using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArraySample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ArrayLengthExample();
            ArrayRankExample();
            ArrayClearExample();
            ArraySortExample();
            ArrayReverseExample();
        }

        static void ArrayLengthExample()
        {
            double[] x1 = new double[] { 1.1, 1.2, 1.3 };
            for (int i = 0; i < x1.Length; i++)
                Console.Write(x1[i] + " ");
            Console.WriteLine();
        }

        static void ArrayRankExample()
        {
            int[] n1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };                   // 1次元配列
            int[ , ] n2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };    // 2次元配列
            int r1 = n1.Rank;           // r1 = 1
            int r2 = n2.Rank;           // r2 = 2
            Console.WriteLine("r1 = " + r1);
            Console.WriteLine("r2 = " + r2);
        }

        static void ArrayClearExample()
        {
            int[] n1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            // 配列n1をn1[3]から4個分初期化
            Array.Clear(n1, 3, 4);      // 1 2 3 0 0 0 0 8 9
            PrintArray(n1);

            // 配列n1の全要素を初期化
            Array.Clear(n1, 0, n1.Length);  // 0 0 0 0 0 0 0 0 0
            PrintArray(n1);
        }

        static void ArraySortExample()
        {
            int[] n1 = { 28, 56, 23, 79, 12, 43, 93, 81, 54, 73 };

            // 配列n1をn1[3]から4個分並び替え
            Array.Sort(n1, 3, 4);           // 28 56 23 12 43 79 93 81 54 73
            PrintArray(n1);

            // 配列n1の全要素を昇順に並び替え
            Array.Sort(n1);                 // 12 23 28 43 54 56 73 79 81 93
            PrintArray(n1);

        }

        static void ArrayReverseExample()
        {
            int[] n1 = { 28, 56, 23, 79, 12, 43, 93, 81, 54, 73 };

            // 配列n1をn1[3]から4個分反転
            Array.Reverse(n1, 3, 4);        // 28 56 23 93 43 12 79 81 54 73
            PrintArray(n1);

            // 降順に並び替える
            // 配列n1の全要素を昇順に並び替えてから全要素を反転
            Array.Sort(n1);
            Array.Reverse(n1);              // 93 81 79 73 56 54 43 28 23 12
            PrintArray(n1);
        }

        static void PrintArray(int[] n)
        {
            foreach (int i in n)
                Console.Write(i + " ");
            Console.WriteLine();

        }
    }
}
