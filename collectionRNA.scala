abstract class Base
case object A extends Base
case object U extends Base
case object G extends Base
case object C extends Base

object Base {
    val fromInt: Int => Base = Array(A, U, G, C)
    val toInt: Base => Int = Map(A -> 0, U -> 1, G -> 2, C -> 3)
}

import scala.collection.{View, mutable}
import scala.collection.immutable.{IndexedSeq, IndexedSeqOps}

final class RNA2 private (val groups: Array[Int], val length: Int)
        extends IndexedSeq[Base]
        with IndexedSeqOps[Base, IndexedSeq, RNA2] {

    import RNA2._

    def apply(idx: Int): Base = {
        if (idx < 0 || length <= idx)
            throw new IndexOutOfBoundsException
        Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
    }

    override def className = "RNA2"

    override protected def fromSpecific(source: IterableOnce[Base]): RNA2 =
        fromSeq(source.iterator.toSeq)
    override protected def newSpecificBuilder: mutable.Builder[Base, RNA2] =
        iterableFactory.newBuilder[Base].mapResult(fromSeq)
    override def empty: RNA2 = fromSeq(Seq.empty)

    // RNA2を返すための多重定義メソッド
    def appended(base: Base): RNA2 = fromSpecific(
        new View.Appended(this, base))
    
    def appendedAll(suffix: IterableOnce[Base]): RNA2 =
        concat(suffix)
    
    def concat(suffix: IterableOnce[Base]): RNA2 =
        fromSpecific(this.iterator ++ suffix.iterator)
    
    def flatMap(f: Base => IterableOnce[Base]): RNA2 =
        fromSpecific(new View.FlatMap(this, f))
    
    def map(f: Base => Base): RNA2 =
        fromSpecific(new View.Map(this, f))

    def prepended(base: Base): RNA2 = fromSpecific(
        new View.Prepended(base, this))
    
    def prependedAll(prefix: IterableOnce[Base]): RNA2 =
        fromSpecific(prefix.iterator ++ this.iterator)
    
    // concatの記号による別名
    @inline final def ++ (suffix: IterableOnce[Base]): RNA2 =
        concat(suffix)
}

object RNA2 {
    // 塩基識別情報を表現するために必要なビット数
    private val S = 2
    // Intに収まる塩基識別情報の数
    private val N = 32 / S
    // 塩基識別情報を分離するビットマスク
    private val M = (1 << S) - 1

    def fromSeq(buf: collection.Seq[Base]): RNA2 = {
        val groups = new Array[Int]((buf.length + N - 1) / N)
        for (i <- 0 until buf.length)
            groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
        new RNA2(groups, buf.length)
    }
    def apply(bases: Base*) = fromSeq(bases)
}

RNA2.fromSeq(List(A, G, U, A))
val rna1 = RNA2(A, U, G, G, C)
rna1.take(3)
rna1.filter(_ != U)
rna1.map(base => base)
rna1 ++ rna1

val rna2 = RNA2(A, U, G, G, C)
rna1.map(base => base)
rna1 ++ rna1

val bases: Iterable[Base] = List(A, U, C, C)
// bases.to(RNA2)  // エラー
