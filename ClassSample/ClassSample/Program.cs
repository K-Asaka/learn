using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
        }
    }

    class VirtualPet
    {
        public string Name { get; set; }
        public int Mood { get; set; }
        public int Energy { get; set; }
        // コンストラクター
        public VirtualPet(string name)
        {
            Name = name;
            Mood = 5;
            Energy = 100;
        }

        public virtual void Eat()
        {
        }

        public virtual void Play()
        {
        }

        public virtual void Sleep()
        {
        }
    }
}