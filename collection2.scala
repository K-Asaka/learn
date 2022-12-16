import scala.collection.immutable._
import scala.collection.mutable.Buffer
object Color extends Enumeration {
    val Red, Green, Blue = Value
}
val a = 5
val b = 15
val c = 25
val x = "abc"
val y = "def"
val z = "hoge"
Iterable("x", "y", "z")
Map("x" -> 24, "y" -> 25, "z" -> 26)
Set(Color.Red, Color.Green, Color.Blue)
SortedSet("hello", "world")
Buffer(x, y, z)
IndexedSeq(1.0, 2.0)
LinearSeq(a, b, c)
List(1, 2, 3)
HashMap("x" -> 24, "y" -> 25, "z" -> 26)
List(1, 2, 3) map (_ + 1)
Set(1, 2, 3) map (_ * 2)

val xs = List(1, 2, 3, 4, 5)
val git = xs grouped 3
git.next()
git.next()
val sit = xs sliding 3
sit.next()
sit.next()
sit.next()

Seq(1, 2, 3)(1)
Set('a', 'b', 'c')('b')
Set()('a')
Map('a' -> 1, 'b' -> 10, 'c' -> 100)('b')

val fruit = Set("apple", "orange", "peach", "banana")
fruit("peach")
fruit("potato")
