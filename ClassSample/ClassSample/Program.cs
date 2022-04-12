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
            var book1 = MakeBookObject();
            var book2 = MakeBookObject();
            book1.Print();
            book2.Print();
        }

        public static Book MakeBookObject()
        {
            Console.Write("書籍名⇒");
            var title = Console.ReadLine();
            Console.Write("著者名⇒");
            var author = Console.ReadLine();
            Console.Write("ページ数⇒");
            var pages = Console.ReadLine();
            var book = new Book
            {
                Title = title,
                Author = author,
                Pages = int.Parse(pages),
                Rating = 3
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

        public void Print()
        {
            Console.WriteLine($"■{this.Title}");
            Console.WriteLine($"  {this.Author}  {this.Pages}ページ  評価: {this.Rating}");
        }
    }
}