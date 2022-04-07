using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MySample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("ご希望の時間帯の番号を選択してください。");
            Console.WriteLine(" 1: 10時から12時");
            Console.WriteLine(" 2: 13時から15時");
            Console.WriteLine(" 3: 15時から18時");
            var line = Console.ReadLine();
            var value = int.Parse(line);
            
            switch (value)
            {
                case 1:
                    Console.WriteLine("10時から12時がご希望ですね。");
                    break;
                case 2:
                    Console.WriteLine("13時から15時がご希望ですね。");
                    break;
                case 3:
                    Console.WriteLine("15時から18時がご希望ですね。");
                    break;
                default:
                    Console.WriteLine("入力した値に誤りがあります。");
                    break;
            }


            var word = Console.ReadLine();
            var term = "";

            switch (word)
            {
                case "API":
                    term = "Application Programming Interface";
                    break;
                case "RDB":
                    term = "Relational Database";
                    break;
                case "UI":
                    term = "User Interfadce";
                    break;
            }

            if (term != "")
            {
                Console.WriteLine("{0}は{1}の略です。", word, term);
            }
        }
    }
}
