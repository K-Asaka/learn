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
            var cardA = new Card(CardSuit.Spade, 4);
            var cardB = cardA;
            cardA.Number = 12;
            Console.WriteLine($"CardA: Suit:{cardA.Suit}, Number: {cardA.Number}");
            Console.WriteLine($"CardB: Suit:{cardB.Suit}, Number: {cardB.Number}");
        }
    }
    // CardSuit列挙型の定義
    enum CardSuit
    {
        Club, Spade, Heart, Diamond
    }
    // Card構造体の定義
    struct Card
    {
        public CardSuit Suit { get; set; }
        public int Number { get; set; }

        public Card(CardSuit suit, int number)
        {
            Suit = suit;
            Number = number;
        }
    }
}