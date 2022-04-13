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
            var king = new Card(CardSuit.Spade, 13);
            Console.WriteLine($"Suit: {king.Suit}, Number: {king.Number}");
            ChangeToAce(king);

            Console.WriteLine($"Suit: {king.Suit}, Number: {king.Number}");
        }

        private static void ChangeToAce(Card card)
        {
            card.Number = 1;
        }
    }
    // CardSuit列挙型の定義
    enum CardSuit
    {
        Club, Spade, Heart, Diamond
    }
    // Card構造体の定義
    class Card
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