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
            var pet = new VirtualPet("エイミー");
            // pet.Name = "リサ"; // 代入できないのでコンパイルエラーになる

            Console.WriteLine(pet.Name);
            Console.WriteLine(pet.Mood);
            Console.WriteLine(pet.Energy);
        }
    }
    class VirtualPet
    {
        public string Name { get; private set; }
        public int Mood { get; set; } = 5;
        public int Energy { get; set; } = 100;

        // コンストラクター
        public VirtualPet(string name)
        {
            Name = name;
        }
    }
}