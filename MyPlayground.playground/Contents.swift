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

// 配列の利用
// ミュータブル(可変)な配列
var array1: [String] = [String]()
array1.append("りんご")        // 要素を追加できる
array1.append("ごりら")        // 要素を追加できる
// イミュータブル(不変)な配列
let array2: [String] = [String]()
//array2.append("りんご")        // これはエラーになる。要素を追加できない
// イミュータブル(不変)な配列
let array3: [String] = ["りんご", "ごりら"]

// 添字を利用して値を参照した例
let array = ["りんご", "ごりら", "らくだ"]
let first = array[0]        // りんご
let second = array[1]       // ごりら
let third = array[2]        // らくだ
// JavaのGenericsのように<>を利用した型宣言も可能
// let array: Array<String> = Array<String>()

// 辞書
// ミュータブル(可変)な辞書
var dic1: [String:String] = [String:String]()
dic1["りんご"] = "1個"
dic1["ごりら"] = "1匹"
// イミュータブル(不変)な辞書
let dic2: [String:String] = [String:String]()
//dic2["りんご"] = "1個"      // 要素を追加できない
// イミュータブル(不変)の宣言例
let dic3: [String:String] = ["りんご":"1個", "ごりら":"1匹"]

// 何もないことを意味する値nilとOptional型
// Optional型変数を暗ラップして利用する
var value10: String?     // OptionalのString型変数の宣言
value10 = "こんにちは"     // 値の設定
print(value10)           // 「Optional("こんにちは")」というアンラップ前の値が出力されてしまう
if let value10 = value10 {    // アンラップ処理
    print(value10)           // 「こんにちは」というアンラップ語の値が出力される
}

// アンラップ処理後の変数を利用しない場合は変数名を省略できる
var value11: String?    // OptionalのString型変数の宣言
value11 = "こんにちは"    // 値の設定
if let _ = value11 {    // アンラップ処理
    print("value11はnilではない")
}

// アンラップしたあとの変数名をアンラップ前の変数名と違う名前にした場合、
// アンラップ前の変数の値がアンラップ後の処理で使われてしまう可能性がある。
// それを防ぐために、アンラップ前の変数名とアンラップ後の変数名には同名を指定したほうがよい
var value12: String?
value12 = "こんにちは"
//if let unwrappedValue = value12 {
if let value12 = value12 {
    //print(unwrappedValue)
    print(value12)
}

// 関数の記述と利用方法
// 関数の記述例
// Int型の引数Valueと、Int型の戻り値を持つmyFunc関数
func myFunc(value: Int) -> Int {
    var resultValue: Int = 0
    // 処理は省略
    return resultValue
}

// 引数を指定して関数呼び出し
myFunc(value: 100)

// 引数の別名
// テストの点数を表示する関数
func showTestScore(score: Int) -> String {
    return "数学の点数は\(score)点"
}
// 引数名をmathematicsTestScoreとするが関数内ではscoreで扱う
func showTestScore(mathematicsTestScore score: Int) -> String {
    return "数学の点数は\(score)点"
}
showTestScore(mathematicsTestScore: 80)

// 引数名の省略
// 値を追加する関数
//func addValue(value: Int) {
// 引数名を省略
func addValue(_ value: Int) {
    // 処理省略
}
// 引数名を指定して関数呼び出し
//addValue(value: 100)
addValue(100)

// エラーを通知するthrow処理
// throwを利用した処理例
enum MyError: Error {
    case InvalidValue
}
// エラーをthrowする可能性がある関数
func doubleUp(value: Int) throws -> Int {
    if value < 0 {
        throw MyError.InvalidValue
    }
    return value * 2
}
// エラーハンドリングが必要なdoubleUp関数を利用
do {
    var doubleResultValue = try doubleUp(value: 10) // try句を付ける必要がある
    print("正常終了")
} catch MyError.InvalidValue {
    print("エラー発生")
}

// 必ず処理するdefer処理
// 時間がかかる処理の時間を計測する例
// エラーをthrowする可能性がある関数
func longMethod() throws {
    // 時間がかかる処理
    // エラーが発生すると処理終了時間が表示されない
    // deferを利用するとエラーが発生しても必ず処理が行われる
    throw MyError.InvalidValue
}
// エラーハンドリングが必要なlongMethod関数を利用
do {
    // 処理終了時に必ず行う処理
    defer {
        print("処理終了時間: \(Date())")
    }
    print("処理開始時間: \(Date())")
    try longMethod()        // try句を付ける必要がある
    //print("処理終了時間: \(Date())")
} catch {
    print("エラー発生")
}
