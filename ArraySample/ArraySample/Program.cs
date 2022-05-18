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
        }

        static void ArrayLengthExample()
        {
            double[] x1 = new double[] { 1.1, 1.2, 1.3 };
            for (int i = 0; i < x1.Length; i++)
                Console.Write(x1[i] + " ");
            Console.WriteLine();
        }
    }
}
