class SlowAppendQueue[T](elems: List[T]) {      // 効率が悪い
    def head = elems.head
    def tail = new SlowAppendQueue(elems.tail)
    def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}

class SlowHeadQueue[T](smele: List[T]) {        // 効率が悪い
    // smeleはelemsの逆
    def head = smele.last
    def tail = new SlowHeadQueue(smele.init)
    def enqueue(x: T) = new SlowHeadQueue(x :: smele)
}

// trait Queue[+T] {
//     // [T]: 不変　[+T]: 共変　[-T]: 反変
//     def head: T
//     def tail: Queue[T]
//     def enqueue[U >: T](x: U): Queue[U]
// }

// object Queue {
//     // 初期要素'xs'を使ってキューを構築する
//     def apply[T](xs: T*): Queue[T] =
//         new QueueImpl[T](xs.toList, Nil)
    
//     private class QueueImpl[T](
//         private val leading: List[T],
//         private val trailing: List[T]
//     ) extends Queue[T] {

//         def mirror = 
//             if (leading.isEmpty)
//                 new QueueImpl(trailing.reverse, Nil)
//             else
//                 this
            
//         def head: T = mirror.leading.head

//         def tail: QueueImpl[T] = {
//             val q = mirror
//             new QueueImpl(q.leading.tail, q.trailing)
//         }

//         def enqueue(x: T) = 
//             new QueueImpl(leading, x :: trailing)
//     }
// }

// class Queue[T] private (
//     private val leading: List[T],
//     private val trailing: List[T]
// ) {
//     def this() = this(Nil, Nil)
//     def this(elems: T*) = this(elems.toList, Nil)


//     private def mirror = 
//         if (leading.isEmpty) 
//             new Queue(trailing.reverse, Nil)
//         else
//             this
//     def head = mirror.leading.head

//     def tail = {
//         val q = mirror
//         new Queue(q.leading.tail, q.trailing)
//     }

//     def enqueue(x: T) =
//         new Queue(leading, x :: trailing)
// }

// val q = new Queue(1, 2, 3)
// val q1 = q enqueue 4
// q

// class Cell[T](init: T) {
//     private[this] var current = init
//     def get = current
//     def set(x: T) = { current = x }
// }

// val a1 = Array("abc")
// //val a2: Array[Any] = a1
// val a2: Array[Object] = a1.asInstanceOf[Array[Object]]

// class StrangeIntQueue extends Queue[Int] {
//     override def enqueue(x: Int) = {
//         println(math.sqrt(x))
//         super.enqueue(x)
//     }
// }

// class Queue[+T] (
//         private val leading: List[T],
//         private val trailing: List[T] ) {
//     def enqueue[U >: T](x: U) =
//         new Queue[U](leading, x :: trailing)
// }

trait OutputChannel[-T] {
    def write(x: T): Unit
}

class Queue[+T] private (
    private[this] var leading: List[T],
    private[this] var trailing: List[T]
) {
    private def mirror() =
        if (leading.isEmpty) {
            while (!trailing.isEmpty) {
                leading = trailing.head :: leading
                trailing = trailing.tail
            }
        }
    def head: T = {
        mirror()
        leading.head
    }
    def tail: Queue[T] = {
        mirror()
        new Queue(leading.tail, trailing)
    }
    def enqueue[U >: T](x: U) =
        new Queue[U](leading, x :: trailing)
}
