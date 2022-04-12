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
            var person = new Person
            {
                FirstName = "隆之",
                LastName = "森本"
            };
            var name1 = person.AddTitle("先生");
            var name2 = person.AddTitle();
            Console.WriteLine(name1);
            Console.WriteLine(name2);
        }
    }

    class Person
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public string AddTitle(string title = "様")
        {
            return $"{LastName}{FirstName} {title}";
        }
    }
}