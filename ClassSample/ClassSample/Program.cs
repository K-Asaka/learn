using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var price = GetPrice();
            var discount = (int)(price * 0.01);
            Console.WriteLine($"割引額{discount}円");
        }

        private static int GetPrice()
        {
            while (true)
            {
                Console.WriteLine("金額を入力してください。");
                var line = Console.ReadLine();
                if (int.TryParse(line, out var num))
                {
                    // 変換に成功。変換した値は変数numに格納される
                    return num;
                }
                // 変換に失敗。再度繰り返す
                Console.WriteLine("入力に誤りがあります。");
            }
        }

    }
}