using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace FileSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ExistsExample();
        }

        static void ExistsExample()
        {
            string fileName = @"C:\Windows\explorer.exe";
            if (File.Exists(fileName) == true)
                Console.WriteLine(fileName + "は存在します。");
            else
                Console.WriteLine(fileName + "は存在しません。");
        }

    }
}
