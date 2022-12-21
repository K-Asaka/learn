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
