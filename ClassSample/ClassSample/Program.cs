using System;
using System.Collections.Generic;
using System.Linq;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            VirtualPet pet1 = new FoodiePet("エイミー");
            VirtualPet pet2 = new CheerfulPet("クー");
            VirtualPet pet3 = new SleepyPet("ライアン");
            var pets = new List<VirtualPet>();
            pets.Add(pet1);
            pets.Add(pet2);
            pets.Add(pet3);
            foreach (var pet in pets)
            {
                pet.Eat();
                pet.Play();
                Console.WriteLine($"{pet.Name} 機嫌:{pet.Mood} エネルギー:{pet.Energy}");
            }
        }
    }

    abstract class VirtualPet
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
    class FoodiePet : VirtualPet
    {
        public FoodiePet(string name) : base(name)
        {
        }
        public override void Eat()
        {
            Mood += 3;
            Energy += 5;
            Console.WriteLine("FoodiePet.Eatメソッドが実行されました");
        }

        public override void Play()
        {
            Mood -= 1;
            Energy -= 10;
            Console.WriteLine("FoodiePet.Playメソッドが実行されました");
        }

        public override void Sleep()
        {
            Mood -= 1;
            Energy += 2;
            Console.WriteLine("FoodiePet.Sleepメソッドが実行されました");
        }
    }

    class CheerfulPet : VirtualPet
    {
        public CheerfulPet(string name) : base(name)
        {
        }
        public override void Eat()
        {
            Mood += 0;
            Energy += 5;
            Console.WriteLine("CheerfulPet.Eatメソッドが実行されました");
        }
        public override void Play()
        {
            Mood += 3;
            Energy -= 10;
            Console.WriteLine("CheerfulPet.Playメソッドが実行されました");
        }
        public override void Sleep()
        {
            Mood -= 1;
            Energy += 2;
            Console.WriteLine("CheerfulPet.Sleepメソッドが実行されました");
        }
    }
    class SleepyPet : VirtualPet
    {
        public SleepyPet(string name) : base(name)
        {
        }

        public override void Eat()
        {
            Mood -= 1;
            Energy += 5;
            Console.WriteLine("SleepyPet.Eatメソッドが実行されました");
        }

        public override void Play()
        {
            Mood -= 1;
            Energy -= 10;
            Console.WriteLine("SleepyPet.Playメソッドが実行されました");
        }

        public override void Sleep()
        {
            Mood += 2;
            Energy += 2;
            Console.WriteLine("SleepyPet.Sleepメソッドが実行されました");
        }
    }
}