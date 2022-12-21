trait Increaser {
    def increase(i: Int): Int
}

def increaseOne(increaser: Increaser): Int =
    increaser.increase(1)

increaseOne(
    new Increaser {
        def increase(i: Int): Int = i + 7
    }
)

increaseOne(i => i + 7)

// ScalaからJava 8 Streamを使う方法
import java.util.function.IntUnaryOperator
import java.util.Arrays
val stream = Arrays.stream(Array(1, 2, 3))
stream.map(
    new IntUnaryOperator {
        def applyAsInt(i: Int): Int = i + 1
    }
).toArray

// Scala2.12以降
val stream2 = Arrays.stream(Array(1, 2, 3))
stream2.map(i => i + 1).toArray

// SAM型の代わりに使えるのは関数リテラルだけ
val f = (i: Int) => i + 1
val stream3 = Arrays.stream(Array(1, 2, 3))
// stream3.map(f).toArray   // エラー
stream3.map(i => f(i)).toArray
// またはfの定義を変える
val f2: IntUnaryOperator = i => i + 1
val stream4 = Arrays.stream(Array(1, 2, 3))
stream4.map(f2).toArray
