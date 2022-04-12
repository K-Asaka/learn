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
            var card = new Card(CardSuit.Heart, 8);
            card.Print();
            if (card.Suit == CardSuit.Diamond)
            {
                Console.WriteLine("ダイヤです");
            }
            else
            {
                Console.WriteLine("ダイヤではありません");
            }
        }
    }
    // CardSuit列挙型の定義
    enum CardSuit
    {
        Club,
        Spade,
        Heart,
        Diamond
    }
    // Card構造体の定義
    struct Card
    {
        public CardSuit Suit { get; private set; }
        public int Number { get; private set; }

        public Card(CardSuit suit, int number)
        {
            Suit = suit;
            Number = number;
        }

        public void Print()
        {
            var s = "";
            switch (Suit)
            {
                case CardSuit.Heart:
                    s = "ハート";
                    break;
                case CardSuit.Diamond:
                    s = "ダイヤ";
                    break;
                case CardSuit.Spade:
                    s = "スペード";
                    break;
                case CardSuit.Club:
                    s = "クラブ";
                    break;
            }
            Console.WriteLine($"{s} {Number}");
        }
    }
}