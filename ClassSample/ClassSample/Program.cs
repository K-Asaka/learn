using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var employee = new Employee
            {
                Number = 512,
                FirstName = "理沙",
                LastName = "石井",
                HireDate = new DateTime(2016, 4, 1)
            };
            var s = employee.ToString();
            Console.WriteLine(s);
        }
    }
    class Person
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string FullName
        {
            get { return LastName + FirstName; }
        }
        public string Email { get; set; }

        public virtual void Print()
        {
            Console.WriteLine($"名前: {FullName} ({Email})");
        }

    }
    // 従業員クラス
    class Employee : Person
    {
        // 従業員番号
        public int Number { get; set; }
        // 入社年月日
        public DateTime HireDate { get; set; }

        public override void Print()
        {
            Console.WriteLine($"{Number}:{FullName} ({Email}) {HireDate.Year}年入社");
        }

        public override string ToString()
        {
            var s = $"{Number} {FullName} " +
                    $"{HireDate.Year}年{HireDate.Month}月{HireDate.Day}日入社";
            return s;
        }
    }
    // 顧客クラス
    class Customer : Person
    {
        // 顧客ID
        public string Id { set; get; }
        // 顧客ランク 1～5　5が最上ランク
        public int Rank { get; set; }
        // クレジットカード番号
        public string CreditCardNum { set; get; }
    }
}