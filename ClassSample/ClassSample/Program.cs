using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var book1 = new Book { Title = "伊豆の踊り子", Author = "川端康成" };
            book1.PrintTitle();
            var book2 = new Book { Title = "走れメロス", Author = "太宰治" };
            book2.PrintTitle();
            var book3 = new Book { Title = "銀河鉄道の夜", Author = "宮沢賢治" };
            book3.PrintTitle();
            Book.ClearCount();
            Console.WriteLine(Book.Count);
        }
    }

    class Book
    {
        // 静的プロパティ
        public static int Count { get; set; }

        // 静的メソッド
        public static void ClearCount()
        {
            Count = 0;
        }

        public string Title { get; set; }
        public string Author { get; set; }

        public void PrintTitle()
        {
            Console.WriteLine("書籍名: {0}", Title);
            Count++;

            Console.WriteLine(Count);
        }
    }
}
