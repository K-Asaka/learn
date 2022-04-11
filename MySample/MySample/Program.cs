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
            for (var rate = 0.01m; rate <= 0.10m; rate += 0.01m)
            {
                Console.Write($"rate={rate}: ");
                var sum = 100_000;
                for (var n = 1; n <= 10; n++)
                {
                    sum += (int)(sum * rate);
                    if (sum > 200_000)
                    {
                        Console.WriteLine($"{n}年後に200,000円を超えました。 sum={sum}");
                        break;
                    }
                }
                if (sum <= 200_000)
                {
                    Console.WriteLine($"200,000円を超えませんでした。 sum={sum}");
                }
            }
            Console.WriteLine("ループを終了しました");
        }
    }
}
