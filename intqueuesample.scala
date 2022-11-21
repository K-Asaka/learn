import scala.collection.mutable.ArrayBuffer

object IntQueueSample {
    abstract class IntQueue {
        def get() : Int
        def put(x: Int): Unit
    }

    class BasicIntQueue extends IntQueue {
        private val buf = new ArrayBuffer[Int]
        def get() = buf.remove(0)
        def put(x: Int) = { buf += x }
    }

    trait Doubling extends IntQueue {
        abstract override def put(x: Int) = { super.put(2 * x) }
    }

    trait Incrementing extends IntQueue {
        abstract override def put(x: Int) = { super.put(x + 1) }
    }

    trait Filtering extends IntQueue {
        abstract override def put(x: Int) = {
            if (x >= 0) super.put(x)
        }
    }

    class MyQueue extends BasicIntQueue with Doubling

    def main(args: Array[String]) = {
        val queue = (new BasicIntQueue
            with Incrementing with Filtering)

        queue.put(-1); queue.put(0); queue.put(1)

        println(queue.get())
        println(queue.get())
    }
}