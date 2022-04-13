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
            var lines = new List<string>();
            lines.Add("おはよう");
            lines.Add("こんにちは");
            lines.Add("こんばんは");
            lines.Add("おやすみ");

            var count = lines.Count;
            Console.WriteLine(count);
        }
    }
}