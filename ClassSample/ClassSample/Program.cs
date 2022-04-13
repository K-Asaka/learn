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
    interface IVirtualPet
    {
        string Name { get; }
        int Mood { get; set; }
        int Energy { get; set; }
        void Eat();
        void Play();
        void Sleep();

    }
}