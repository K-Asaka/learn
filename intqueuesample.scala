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

    class MyQueue extends BasicIntQueue with Doubling

    def main(args: Array[String]) = {
        val queue = new BasicIntQueue with Doubling
        queue.put(10)

        println(queue.get())
    }
}