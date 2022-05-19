using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ListSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // リストのインスタンス生成
            List<string> sList = new List<string>();
            // 要素の追加
            sList.Add("First");
            sList.Add("Second");
            sList.Add("Third");

            // 要素の参照
            for (int i = 0; i < sList.Count; i++)
            {
                Console.WriteLine($"sList[{i}] : {sList[i]}");
            }
            Console.WriteLine();

            // リストの初期化
            List<int> iList = new List<int> { 1, 2, 3, 4, 5 };

            // 要素の参照
            for (int i = 0; i < iList.Count; i++)
            {
                Console.WriteLine($"iList[{i}] : {iList[i]}");
            }
            Console.WriteLine();

            // 先頭に要素100を追加
            iList.Insert(0, 100);
            // 要素4の削除
            iList.Remove(4);
            // 2番目の要素の削除
            iList.RemoveAt(2);

            // 要素の参照
            for (int i = 0; i< iList.Count; i++)
            {
                Console.WriteLine($"iList[{i}] : {iList[i]}");
            }

            // 連想配列の宣言と初期化
            Dictionary<string, string> color = new Dictionary<string, string> {
                { "黒", "Black" }, { "白", "White" }, { "黄", "Yellow" } };

            // 配列のように値を追加
            color["赤"] = "Red";
            // Addメソッドでの値の追加
            color.Add("青", "Blue");

            // すべてのキーと値を参照する
            foreach (string key in color.Keys)
            {
                Console.WriteLine($"{key}は{color[key]}です。");
            }
            Console.WriteLine();

            // すべての値を参照する
            foreach (string v in color.Values)
            {
                Console.WriteLine(v);
            }
            Console.WriteLine();

            // 配列のように参照する
            Console.WriteLine($"黄は英語で{color["黄"]}です。");

            // TryGetValueメソッドで参照する
            if (color.TryGetValue("白", out string value))
                Console.WriteLine($"白は英語で{value}です。");

            // キーの存在チェック
            if (color.ContainsKey("緑"))
                Console.WriteLine("緑はキーに存在します。");
            else
                Console.WriteLine("緑はキーに存在しません。");

            // 値の存在チェック
            if (color.ContainsValue("Red"))
                Console.WriteLine("Redは値に存在します。");
            else
                Console.WriteLine("Redは値に存在しません。");
        }
    }
}
