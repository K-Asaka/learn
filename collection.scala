val colors = List("red", "blue", "green")
colors.head
colors.tail
val fiveInts = new Array[Int](5)
val fiveToOne = Array(5, 4, 3, 2, 1)
fiveInts(0) = fiveToOne(4)
fiveInts

import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
buf += 1
buf += 2
buf
3 +=: buf
buf.toList
