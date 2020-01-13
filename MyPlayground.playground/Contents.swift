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

// 符号付き整数の値の範囲を確認
var value1_1: Int       = Int.max       // Intの最大値(9,223,372,036,854,775,807)
var value1_2: Int       = Int.min       // Intの最小値(-9,223,372,036,854,775,808)
var value2_1: Int8      = Int8.max      // Int8の最大値(127)
var value2_2: Int8      = Int8.min      // Int8の最小値(-128)
var value3_1: Int16     = Int16.max     // Int16の最大値(32,767)
var value3_2: Int16     = Int16.min     // Int16の最小値(-32,768)
var value4_1: Int32     = Int32.max     // Int32の最大値(2,147,483,647)
var value4_2: Int32     = Int32.min     // Int32の最小値(-2,147,483,648)
var value5_1: Int64     = Int64.max     // Int64の最大値(9,223,372,036,854,775,807)
var value5_2: Int64     = Int64.min     // Int64の最小値(-9,223,372,036,854,775,808)

// 符号なし整数の値の範囲
var value1_3: UInt      = UInt.max       // UIntの最大値(18,446,744,073,709,551,615)
var value1_4: UInt      = UInt.min       // UIntの最小値(0)
var value2_3: UInt8     = UInt8.max      // UInt8の最大値(255)
var value2_4: UInt8     = UInt8.min      // UInt8の最小値(0)
var value3_3: UInt16    = UInt16.max     // UInt16の最大値(65,535)
var value3_4: UInt16    = UInt16.min     // UInt16の最小値(0)
var value4_3: UInt32    = UInt32.max     // UInt32の最大値(4,294,967,295)
var value4_4: UInt32    = UInt32.min     // UInt32の最小値(0)
var value5_3: UInt64    = UInt64.max     // UInt64の最大値(18,446,744,073,709,551,615)
var value5_4: UInt64    = UInt64.min     // UInt64の最小値(0)

// Bool型の利用例
var flag1: Bool = true
var flag2 = false

// 浮動小数点数を扱う型
var fvalue1_1: Float    = 12.34     // 32ビットの範囲で値の保持が可能
var fvalue1_2: Float    = -12.34    // 32ビットの範囲で負の値の保持が可能
var fvalue2_1: Float    = 123.45    // 64ビットの範囲で値の保持が可能
var fvalue2_2: Float    = -123.45   // 64ビットの範囲で負の値の保持が可能

// 整数と浮動小数点数の変換
// 型が異なる値同士の計算はエラーとなる
// 型を変換してから計算する
let value7 = 3          // 整数
let value8 = 0.14159    // 浮動小数点数
let pi = Double(value7) + value8    // value7をDouble型に変換してから計算する
// piには3.14159が格納される
// 型が範囲を超える値は切り捨てられる
let value9 = Int(pi)
// value9には3が格納される
