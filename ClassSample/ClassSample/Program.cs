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
        }
    }
    class VirtualPet
    {
        public string Name { get; private set; }
        public int Mood { get; set; }
        public int Energy { get; set; }

        // コンストラクター
        public VirtualPet(string name)
        {
            Name = name;
            Mood = 5;
            Energy = 100;
        }
    }
}