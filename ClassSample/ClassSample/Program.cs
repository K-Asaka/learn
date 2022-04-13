using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var person = new Person
            {
                FirstName = "はるか",
                LastName = "佐々木",
                Email = "hsasaki@example.com"
            };
            person.Print();

            var employee = new Employee
            {
                Number = 352,
                FirstName = "涼太",
                LastName = "田中",
                Email = "rtanaka@example.com",
                HireDate = new DateTime(2015, 10, 1)
            };
            employee.Print();
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

        public void Print()
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