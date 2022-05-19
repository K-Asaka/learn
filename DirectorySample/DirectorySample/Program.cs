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
            CreateDirectoryExample();
            DeleteExample();
        }

        static void ExistsExample()
        {
            string directory = @"C:\Program Files\Microsoft Office";
            if (Directory.Exists(directory) == true)
                Console.WriteLine(directory + "ディレクトリは存在します。");
            else
                Console.WriteLine(directory + "ディレクトリは存在しません。");
        }

        static void CreateDirectoryExample()
        {
            try
            {
                if (Directory.Exists("test") == false)
                {
                    Console.WriteLine("testディレクトリが存在しないので作成します。");
                    Directory.CreateDirectory("test");
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
                if (Directory.Exists("test") == true)
                {
                    Console.WriteLine("testディレクトリは存在するので削除します。");
                    Directory.Delete("test");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
