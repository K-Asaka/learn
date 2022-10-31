import scala.collection.mutable

// コンパニオンクラス
class CheckSumAccumulator {
    private var sum = 0
    def add(b: Byte): Unit = { sum += b }
    def checksum(): Int = ~(sum & 0xFF) + 1
}

// シングルトンオブジェクト
// コンパニオンオブジェクト
object ChecksumAccumulator {
    private val cache = mutable.Map.empty[String, Int]
    def calculate(s: String): Int =
        if (cache.contains(s))
            cache(s)
        else {
            val acc = new ChecksumAccumulator2
            for (c <- s)
                acc.add(c.toByte)
            val cs = acc.checksum()
            cache += (s -> cs)
            cs
        }
}