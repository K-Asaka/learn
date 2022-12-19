val buf = collection.mutable.ArrayBuffer.empty[Int]
buf += 1
buf += 10
buf.toArray

val buf2 = collection.mutable.ListBuffer.empty[Int]
buf2 += 1
buf2 += 10
buf2.toList
