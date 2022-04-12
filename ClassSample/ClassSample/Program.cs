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
        }
    }
    class Book
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public int Pages { get; set; }

        int _rating;

        public int Rating
        {
            get
            {
                return _rating;
            }
            set
            {
                if (value <= 1)
                {
                    _rating = 1;
                }
                else if (value >= 6)
                {
                    _rating = 5;
                }
                else
                {
                    _rating = value;
                }
            }
        }
    }
}