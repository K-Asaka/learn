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
            var books = new List<Book>();
            var book1 = new Book("吾輩は猫である", "夏目漱石", 610, 4);
            books.Add(book1);
            var book2 = new Book("人間失格", "太宰治", 212, 5);
            books.Add(book2);
            foreach (var book in books)
            {
                Console.WriteLine($"{book.Title} {book.Author} {book.Rating}");
            }
        }
    }
    class Book
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public int Pages { get; set; }
        public int Rating { get; set; }

        public Book(string title, string author, int pages, int rating)
        {
            Title = title;
            Author = author;
            Pages = pages;
            Rating = rating;
        }
    }
}