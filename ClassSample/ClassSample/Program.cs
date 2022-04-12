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
                LastName = "渡部",
                FirstName = "智史"
            };
            var name = person.FullName;
            Console.WriteLine(name);
        }
    }
    class Person
    {
        // 名
        public string FirstName { get; set; }

        // 姓
        public string LastName { get; set; }

        // 姓名を返す
        public string FullName
        {
            get { return LastName + FirstName; }
        }
    }
}