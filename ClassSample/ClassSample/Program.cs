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
            var card = new Card('H', 8);
            card.Print();
            if (card.Suit == 'D')
            {
                Console.WriteLine("ダイヤです");
            }
            else
            {
                Console.WriteLine("ダイヤではありません");
            }
        }
    }

    // Card構造体
    struct Card
    {
        // プロパティ
        public char Suit { get; private set; }
        public int Number { get; private set; }

        // コンストラクター
        public Card(char suit, int number)
        {
            Suit = suit;
            Number = number;
        }

        // メソッド
        public void Print()
        {
            var s = "";
            switch (Suit)
            {
                case 'H':
                    s = "ハート";
                    break;
                case 'D':
                    s = "ダイヤ";
                    break;
                case 'S':
                    s = "スペード";
                    break;
                case 'C':
                    s = "クラブ";
                    break;
            }
            Console.WriteLine($"{s} {Number}");
        }
    }
}