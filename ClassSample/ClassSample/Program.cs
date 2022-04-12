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
            var mypet = new VirtualPet();
            Console.WriteLine($"Name: {mypet.Name}");
            Console.WriteLine($"Mood: {mypet.Mood}");
            Console.WriteLine($"Energy: {mypet.Energy}");
        }
    }
    class VirtualPet
    {
        // ペットの名前
        public string Name { get; set; }

        // ペットの機嫌を示す(値が大きいと機嫌が良い)
        public int Mood { get; set; }

        // ペットの元気度を示す(エネルギーの値で元気かどうかを判断)
        public int Energy { get; set; }

        // コンストラクターの定義
        public VirtualPet()
        {
            Name = "エイミー";
            Mood = 5;
            Energy = 100;
        }
    }
}