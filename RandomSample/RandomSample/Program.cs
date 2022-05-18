using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RandomSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Random rnd1 = new Random();
            Random rnd2 = new Random();

            for (int i = 0; i < 5; i++)
                Console.Write(rnd1.Next() + " ");
            Console.WriteLine();

            for (int i = 0; i < 5; i++)
                Console.Write(rnd2.Next() + " ");
            Console.WriteLine();
        }
    }
}
