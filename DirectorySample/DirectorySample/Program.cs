using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace DirectorySample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ExistsExample();
        }

        static void ExistsExample()
        {
            string directory = @"C:\Program Files\Microsoft Office";
            if (Directory.Exists(directory) == true)
                Console.WriteLine(directory + "ディレクトリは存在します。");
            else
                Console.WriteLine(directory + "ディレクトリは存在しません。");
        }
    }
}
