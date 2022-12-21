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
