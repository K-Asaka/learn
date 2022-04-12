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
            var str = "インスタンスを生成せずに利用できるメソッドを静的メソッドと言います。";
            if (str.Contains("静的メソッド"))
            {
                Console.WriteLine("文字列の中に「静的メソッド」が含まれています。");
            }
        }
    }
}