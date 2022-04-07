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
            var name = "渡辺";
            var message = name + "さん、おはようございます。";
            Console.WriteLine(message);

            var str = "これは正しい文字列です。" +
                        "+演算子で連結させています。";
            Console.WriteLine(str);

            var s1 = "おはよう。";
            var s2 = "こんにちは。";
            var s3 = "こんばんは。";
            var s4 = "またあした。";
            var str2 = s1 + s2 + s3 + s4;
            Console.WriteLine(str2);
        }
    }
}
