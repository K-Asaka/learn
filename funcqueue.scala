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

trait Queue[T] {
    def head: T
    def tail: Queue[T]
    def enqueue(x: T): Queue[T]
}
object Queue {
    // 初期要素'xs'を使ってキューを構築する
    def apply[T](xs: T*): Queue[T] =
        new QueueImpl[T](xs.toList, Nil)
    
    private class QueueImpl[T](
        private val leading: List[T],
        private val trailing: List[T]
    ) extends Queue[T] {

        def mirror = 
            if (leading.isEmpty)
                new QueueImpl(trailing.reverse, Nil)
            else
                this
            
        def head: T = mirror.leading.head

        def tail: QueueImpl[T] = {
            val q = mirror
            new QueueImpl(q.leading.tail, q.trailing)
        }

        def enqueue(x: T) = 
            new QueueImpl(leading, x :: trailing)
    }
}

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