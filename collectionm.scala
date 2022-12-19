val buf = collection.mutable.ArrayBuffer.empty[Int]
buf += 1
buf += 10
buf.toArray

val buf2 = collection.mutable.ListBuffer.empty[Int]
buf2 += 1
buf2 += 10
buf2.toList

val buf3 = new StringBuilder
buf3 += 'a'
buf3 ++= "bcdef"
buf3.toString

val queue = new scala.collection.mutable.Queue[String]
queue += "a"
queue ++= List("b", "c")
queue
queue.dequeue
queue

val stack = new scala.collection.mutable.Stack[Int]
stack.push(1)
stack
stack.push(2)
stack
stack.pop()
stack
stack.pop()
stack

val map = collection.mutable.HashMap.empty[Int, String]
map += (1 -> "make a web site")
map += (3 -> "profit!")
map(1)
map contains 2
