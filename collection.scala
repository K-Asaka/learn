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

import scala.collection.mutable.ArrayBuffer
val buf2 = new ArrayBuffer[Int]()
buf2 += 12
buf2 += 15
buf2
buf2.length
buf2(0)

def hasUpperCase(s: String) = s.exists(_.isUpper)
hasUpperCase("Robert Frost")
hasUpperCase("e e cummings")
