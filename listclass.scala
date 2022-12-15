val xs = List(1, 2, 3)
var ys: List[Any] = List(1, 2, 3)

abstract class Fruit
class Apple extends Fruit
class Orange extends Fruit

val apples = new Apple :: Nil
val fruits = new Orange :: apples

def incAll(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => x + 1 :: incAll(xs1)
}

var result = List[Int]()    // 非常に効率の悪いアプローチ
for (x <- xs) result = result ::: List(x + 1)
result

import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
for (x <- xs) buf += x + 1
buf.toList
