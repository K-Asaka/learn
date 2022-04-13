using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try
            {
                var total = 1000;
                var line = Console.ReadLine();
                var count = int.Parse(line);
                var ans = total / count;
                Console.WriteLine(ans);
                Console.WriteLine("正常終了");
            }
            catch (System.DivideByZeroException)
            {
                Console.WriteLine("ゼロは入力できません");
            }
            catch (System.FormatException)
            {
                Console.WriteLine("数値を入力してください");
            }
            catch (System.Exception)
            {
                Console.WriteLine("予期しないエラーが発生しました");
            }
        }
    }
}