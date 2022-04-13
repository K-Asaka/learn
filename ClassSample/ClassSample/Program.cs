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
            //var lines = new List<string>();
            var lines = new List<string>
            {
                "おはよう",
                "こんにちは",
                "こんばんは",
            };
            lines.Add("おやすみ");
            lines.Add("さようなら");
        }
    }
}