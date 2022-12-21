class Point(var x: Int, var y: Int) {   // 問題あり
    override def hashCode = (x, y).##
    override def equals(other: Any) = other match {
        case that: Point => this.x == that.x && this.y == that.y
        case _ => false
    }
}

val p1, p2 = new Point(1, 2)
val q = new Point(2, 3)
p1 equals p2
p1 equals q

import scala.collection.mutable
val coll = mutable.HashSet(p1)
coll contains p2

val p2a: Any = p2
p1 equals p2a

collection.mutable.HashSet(p1) contains p2

val p = new Point(1, 2)
val coll2 = collection.mutable.HashSet(p)
coll2 contains p

p.x += 1

coll2 contains p

coll2.iterator contains p


object Color extends Enumeration {
    val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
}

class ColoredPoint(x: Int, y: Int, val color: Color.Value)
        extends Point(x, y) {       // 問題: equalsが対称率を満たさなくなる

    override def equals(other: Any) = other match {
        case that: ColoredPoint =>
            (this.color == that.color) && super.equals(that)
        case that: Point =>
            that equals this
        case _ =>
            false
    }
}

val cp1 = new Point(1, 2)
val cp2 = new ColoredPoint(1, 2, Color.Red)
cp1 equals cp2
cp2 equals cp1
collection.mutable.HashSet[Point](cp1) contains cp2
collection.mutable.HashSet[Point](cp2) contains cp1

val redp = new ColoredPoint(1, 2, Color.Red)
val bluep = new ColoredPoint(1, 2, Color.Blue)
redp == cp1
cp1 == bluep
redp == bluep
