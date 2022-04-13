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
            var book = GetBook();
            if (book == null)
            {
                Console.WriteLine("Bookオブジェクトは生成できませんでした");
            }
            else
            {
                Console.WriteLine($"{book.Title}  {book.Author}");
            }
        }

        private static Book GetBook()
        {
            var line = Console.ReadLine();
            var items = line.Split(',');
            if (items.Length != 2)
            {
                return null;
            }
            var book = new Book
            {
                Title = items[0],
                Author = items[1],
            };
            return book;
        }
    }
    class Book
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public int Pages { get; set; }
        public int Rating { get; set; }
    }
}