val a1 = Array(1, 2, 3)
val a2 = a1 map (_ * 3)
val a3 = a2 filter (_ % 2 != 0)
a3.reverse

val seq: collection.Seq[Int] = a1
val a4: Array[Int] = seq.toArray
a1 eq a4

val seq2: collection.Seq[Int] = a1
seq2.reverse
val ops: collection.ArrayOps[Int] = a1
ops.reverse
a1.reverse
intArrayOps(a1).reverse

// これは間違い
// def evenElems[T](xs: Vector[T]): Array[T] = {
//     val arr = new Array[T]((xs.length + 1) / 2)
//     for (i <- 0 until xs.length by 2)
//         arr(i / 2) = xs(i)
//     arr
// }
// これなら動作する
import scala.reflect.ClassTag
def evenElems[T: ClassTag](xs: Vector[T]): Array[T] = {
    val arr = new Array[T]((xs.length + 1) / 2)
    for (i <- 0 until xs.length by 2)
        arr(i / 2) = xs(i)
    arr
}

evenElems(Vector(1, 2, 3, 4, 5))
evenElems(Vector("this", "is", "a", "test", "run"))
// クラスタグのない他の型パラメーターになっているとクラスタグが作れずエラーになる
// def wrap[U](xs: Vector[U]) = evenElems(xs)
def wrap[U: ClassTag](xs: Vector[U]) = evenElems(xs)
