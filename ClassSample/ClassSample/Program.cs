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
            var sale = new Sale
            {
                ProductName = "おにぎり",
                UnitPrice = 120,
                Quantity = 4
            };

            var amount = sale.GetAmount();
            Console.WriteLine($"合計金額: {amount}円");
        }
    }

    class Sale
    {
        public string ProductName { get; set; }
        public int UnitPrice { get; set; }
        public int Quantity { get; set; }

        public int GetAmount()
        {
            var amount = UnitPrice * Quantity;
            return amount;
        }
    }
}
