List(1, 2, 3)
Iterable(1, 2, 3)
collection.mutable.Iterable(1, 2, 3)

import collection.JavaConverters._
import collection.mutable._

val jul: java.util.List[Int] = ArrayBuffer(1, 2, 3).asJava
val buf: Seq[Int] = jul.asScala
val m: java.util.Map[String, Int] =
    HashMap("abc" -> 1, "hello" -> 2).asJava

// val jul2: java.util.List[Int] = List(1, 2, 3)
// jul2.add(7)
