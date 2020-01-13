import UIKit

var str = "Hello, playground"
1 + 2

10 - 1  // 引き算
10 + 2  // 掛け算
10 / 3  // 割り算の商を求める計算
10 % 3  // 割り算の余を求める計算

"こんにちは"

"Hello, " + "playground"

print("Hello, " + "playground")

// 一人目に対しての質問
print("あなたは何が好きですか？")
print("りんごです")
// 二人目に対しての質問
print("あなたは何が好きですか？")
print("みかんです")

var value: String = "Hello, playground"
// 型を省略した指定例
// var value = "Hello, playground"

// 変数の宣言
var st = "あなたは何が好きですか？"
// 一人目に対しての質問
print(st)
print("りんごです")
// 二人目に対しての質問
print(st)
print("みかんです")

// 変数の値を変更
st = "あなたの好きな食べ物は何ですか？"


let value2: String = "Hello, playground"
// value2 = "みかんが好きです"     // エラー


// 変数
var str1 = "魚が1匹います"
str1 = "魚が2匹います"

var value3 = "りんごを1個、みかんを2個、きゅうりを3本、魚を4匹買いました"

// 個数の書き変え例
var a = 1                   // りんごの数
var b = 2                   // みかんの数
var c = 3                   // きゅうりの数
var d = 4                   // 魚の数
let aString = String(a)     // りんごの数を文字列に変換
let bString = String(b)     // みかんの数を文字列に変換
let cString = String(c)     // きゅうりの数を文字列に変換
let dString = String(d)     // 魚の数を文字列に変換
// 文字列を結合。value4変数には "りんごを1個、みかんを2個、きゅうりを3本、魚を4匹買いました" という文字列が設定される
var value4 = "りんごを" + aString + "個、みかんを" + bString + "個、きゅうりを" + cString + "本、魚を" + dString + "匹買いました"

// ¥(変数)を利用
var value5 = "りんごを\(a)個、みかんを\(b)個、きゅうりを\(c)本、魚を\(d)匹買いました"

// 埋め込む文字列が少ないときは結合したほうが読みやすいこともある
var a1 = 10                                        // りんごの数を宣言
var aString1 = String(a1)                           // 文字列に変換
var value6 = "りんごを" + aString1 + "個買いました"    // 文字列を結合する
