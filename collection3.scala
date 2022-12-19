val str = 1 #:: 2 #:: 3#:: LazyList.empty

def fibFrom(a: Int, b: Int): LazyList[Int] =
    a #:: fibFrom(b, a + b)

val fibs = fibFrom(1, 1).take(7)
fibs.toList

val vec = scala.collection.immutable.Vector.empty
val vec2 = vec :+ 1 :+ 2
val vec3 = 100 +: vec2
vec3(0)
val vec4 = Vector(1, 2, 3)
vec4 updated (2, 4)
vec4

collection.immutable.IndexedSeq(1, 2, 3)

val empty = scala.collection.immutable.Queue[Int]()
val has1 = empty.enqueue(1)
val has123 = has1.enqueueAll(List(2, 3))
val (element, has23) = has123.dequeue
