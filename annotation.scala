import annotation._

class strategy(arg: Annotation) extends Annotation
class delayed extends Annotation

// @strategy(@delayed) def f () = {}
@strategy(new delayed) def f () = {}

@deprecated def bigMistake() = {}
@deprecated("代わりにnewShinyMethod()を使ってください")
def bigMistake2() = {}

object Deprecation2 {
    def main(args: Array[String]) = {
        bigMistake2()
    }
}
// scalac -deprecation annotation.scala

// 揮発性フィールド
@volatile

// バイナリシリアライゼーション
@SerialVersionUID(1234)

// 末尾再帰
@tailrec

// パターンのチェック回避
@unchecked

// ネイティブメソッド
@native
def beginCountdown() = {}
