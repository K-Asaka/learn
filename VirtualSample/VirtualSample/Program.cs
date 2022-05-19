using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VirtualSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Mark m1 = new Triangle();
            Mark m2 = new Square();

            DrawMark(m1);
            DrawMark(m2);
        }

        static void DrawMark(Mark m)
        {
            Console.Write(m.Name + "マークを描画する：");
            m.Draw();
        }
    }

    class Mark
    {
        public Mark(string name)
        {
            Name = name;
        }
        public string Name { get; set; }

        public virtual void Draw()      // 仮想メソッド
        {
            Console.WriteLine("");      // とりあえず空文字列を描く
        }
    }

    class Triangle : Mark
    {
        public Triangle() : base("三角") { }

        public override void Draw()     // 仮想メソッドのオーバーライド
        {
            Console.WriteLine("△");
        }
    }

    class Square : Mark
    {
        public Square() : base("四角") { }

        public override void Draw()     // 仮想メソッドのオーバーライド
        {
            Console.WriteLine("□");
        }
    }
}
