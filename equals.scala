class Point(val x: Int, val y: Int) {
    // equalsの定義としてまったく間違っているもの
    def equals(other: Point): Boolean =
        this.x == other.x && this.y == other.y
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

