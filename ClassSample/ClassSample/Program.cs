using System;
using System.IO;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try
            {
                ReadSample();
            }
            catch
            {
                Console.WriteLine("ReadSampleでエラーが発生");
            }
        }

        private static void ReadSample()
        {
            var file = new StreamReader("test.txt");
            try
            {
                while (file.EndOfStream == false)
                {
                    var line = file.ReadLine();
                    if (line == "")
                    {
                        return;
                    }
                    Console.WriteLine(line);
                }
            }
            finally
            {
                file.Dispose();
            }
        }
    }
}