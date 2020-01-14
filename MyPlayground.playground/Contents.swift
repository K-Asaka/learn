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

// typealiasで型名に別名を付ける
typealias ColorCode = UInt8
// R(赤色)の値設定
let r = ColorCode.max

// クラスのインスタンス化
var radio = UISwitch()
// プロパティの設定
radio.isOn = true
// メソッドによるプロパティの設定
radio.setOn(false, animated: false)

// 独自クラスを作成する
class Dog {
    // プロパティ・メソッドを記述
    var name = ""       // 名前
    var type = ""       // 種類
    var birthday = ""   // 誕生日
    
    // 吠える
    func bark() {
        print("わんわん")
    }
}
// 盲導犬クラス
class GuideDog: Dog {
    override func bark() {
        super.bark()        // 継承元のクラスのbarkメソッドが呼び出される
        print("きゃんきゃん")
    }
}
// 独自クラスのインスタンス化
var dog = Dog()
dog.bark()                // 吠える
var guideDog = GuideDog()
guideDog.bark()           // 吠える

// 構造体の記述例
// 構造体の定義
struct MyStruct {
    // 構造体内でのプロパティの宣言
    var value: String?
    // 構造体内でのメソッドの宣言
    func method(value: Int) -> Int {
        let resultValue: Int = 0
        // 処理は省略
        return resultValue
    }
}

// 列挙した値の管理に適したenum
// enumの定義
enum Fruit {
    case Apple
    case Orange
}

// 複数の値をまとめるタプル
// 最小値と最大値を返却する
func requestMinAndMax() -> (min: Int, max: Int) {
    // 値はタプルで返却する
    return (1, 100)
}
let minAndMax = requestMinAndMax()
let minValue = minAndMax.min    // 最小値を取り出す。minAndMax.0でも取り出し可能
let maxValue = minAndMax.max    // 最大値を取り出す。minAndMax.1でも取り出し可能

// for-in文
// 0〜9の繰り返し処理
for index in 0...9 {
    print("index:\(index)")
}
// 配列を利用した繰り返し処理の例
let values = ["りんご", "ごりら", "らくだ"]
for value in values {
    print(value)
}

// ..<は境界の値を含まない
for index in 0..<9 {
    print("index:\(index)")
}

// カウンタの数字を引用しない場合は、_で省略できる
// 次のプログラムの実行結果は「index」の文字列が9回出力されるのみとなる
for _ in 0..<9 {
    print("index")
}

// for-in-enumerated文
// カウンタと項目名の両方を出力する例
// 配列
let values2 = ["りんご", "ごりら", "らくだ"]
// カウンタの変数名と項目名を記述する
for (index, value) in values2.enumerated() {
    print("\(index) : \(value)")
}

let value13 = 5
if value13 < 10 {
    print("valueが10より小さいです")
}

let value14 = 10
if value14 < 10 {
    print("valueが10より小さいです")
} else {
    print("valueが10以上です")
}

let value15 = 101
if value15 < 10 {       // 条件文その1
    print("valueが10より小さいです")
} else if value15 > 100 {   // 条件文その2
    print("valueが100より大きいです")
} else {        // 上記の条件を満たさないとき
    print("どちらでもない")
}

// switch文
let value16 = 100
switch value16 {
case 0:             // 0のとき
    print("valueが0のとき")
case 1...100:       // 1〜100のとき
    print("valueが1〜100のとき")
default:
    print("上記以外")
}

// switchの文の値に文字列を指定した例
let value17 = "みかん"
switch value17 {
case "りんご":
    print("りんごです")
case "みかん":
    print("みかんです")
default:
    print("どちらでもない")
}

// switch文の値にenum値を使用した例
enum Fruit2 {
    case Apple
    case Orange
}

let value18 = Fruit2.Orange
switch value18 {
case .Apple:
    print("Appleです")
case .Orange:
    print("Orangeです")
}

// 複数の処理を続けて行えるfallthrough
let value19 = "りんご"
switch value19 {
case "りんご":
    print("りんごです")
    fallthrough             // 次のcase文の処理も実行する
case "みかん":
    print("みかんです")
default:
    print("どちらでもない")
}

// while文
// 1〜10の数をすべて足す
var count = 1
var result = 0
while count <= 10 {     // countの値が10以下の場合は処理を繰り返す
    result += count     // countの値をresultに加算する
    count += 1          // 1をcountの値に加算する
}
print("合計は\(result)")

// guard文
// 商品を購入する
func buyItem(myMoney: Int?) {
    // 所持金があるかチェック
    guard let money = myMoney else {
        // 処理終了
        print("所持金がありません")
        return
    }
    print("所持金\(money)円で商品を購入します")
    // 商品を購入する処理
}
buyItem(myMoney: nil)
buyItem(myMoney: 1000)

// Swiftでより簡潔にコードを記述する方法
// filter
var values3 = [11, 4, 25, 16, 5]
// filterを利用して対象を絞り込む
let results3 = values3.filter { (x: Int) -> Bool in
    // 10より小さい値のみにする
    if x < 10 {
        return true
    }
    return false
}
print(results3)     // 出力結果は[4, 5]

// 引数に「$0」を利用して簡潔に記述した例
let results4 = values3.filter { $0 < 10 }

// map
// mapを利用して値を変化させる
let results5 = values3.map { (x: Int) -> Int in
    return x * 2
}
print(results5)
// 引数に「$0」を利用して簡潔に記述した例
let results6 = values3.map { $0 * 2 }

// reduce
// reduceを利用して配列内の値を順次処理する。合計値の初期値は0
let total = values3.reduce(0) { (nowTotal: Int, value: Int) -> Int in
    return nowTotal + value
}
print(total)    // 出力結果は61
// 引数を$0、$1で表現
let total2 = values3.reduce(0) { $0 + $1 }
print(total2)

// sort
// sortを利用して配列内の値を並べ替える
values3.sort { (value1:Int, value2:Int) -> Bool in
    value1 < value2
}
print(values3)       // 出力結果は[4, 5, 11, 16, 25]
// 引数を$0、$1で表現
values3.sort { $0 < $1 }
print(values3)

// for-in-where(フィルタリング)
// カウンタが5のときだけ処理を行わないようにする
for value in 0..<9 where value != 5 {
    print("index\(value)")
}

// case-let-where(パターンマッチング)
// switch文の条件式に「み」ではじまる文字列を指定する例
let value20 = "みかん"
switch value20 {
case let x where x.hasPrefix("み"):      // 定数valueが「み」ではじまるかどうか
    print("みかんです")
case "りんご":
    print("りんごです")
default:
    print("どちらでもない")
}

// for-case-in(繰り返し処理中のパターンマッチング)
// enumの値がAppleのときだけ処理を行う
enum Fruit3 {
    case Apple, Orange
}
// Fruit3の配列を登録
let fruits :[Fruit] = [.Apple, .Orange, .Apple, .Apple]
// Appleのときのみ処理を行う
for case .Apple in fruits {
    print("Appleです")
}
