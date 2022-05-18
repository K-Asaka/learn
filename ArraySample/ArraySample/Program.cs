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
    }
}
