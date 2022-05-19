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
            CreateExample();
            DeleteExample();
        }

        static void ExistsExample()
        {
            string fileName = @"C:\Windows\explorer.exe";
            if (File.Exists(fileName) == true)
                Console.WriteLine(fileName + "は存在します。");
            else
                Console.WriteLine(fileName + "は存在しません。");
        }

        static void CreateExample()
        {
            try
            {
                if (File.Exists("test.txt") == false)
                {
                    Console.WriteLine("test.txt ファイルは存在しないので作成します。");
                    FileStream fs = File.Create("test.txt");
                    fs.Close();     // ファイルをクローズ
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static void DeleteExample()
        {
            try
            {
                if (File.Exists("test.txt") == true)
                {
                    Console.WriteLine("test.txt ファイルは存在するので削除します。");
                    File.Delete("test.txt");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
