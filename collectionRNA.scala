abstract class Base
case object A extends Base
case object U extends Base
case object G extends Base
case object C extends Base

object Base {
    val fromInt: Int => Base = Array(A, U, G, C)
    val toInt: Base => Int = Map(A -> 0, U -> 1, G -> 2, C -> 3)
}

import scala.collection.{AbstractIterator, 
    SpecificIterableFactory, StrictOptimizedSeqOps,
    View, mutable}
import scala.collection.immutable.{IndexedSeq, IndexedSeqOps}

final class RNA private (val groups: Array[Int], val length: Int)
        extends IndexedSeq[Base]
        with IndexedSeqOps[Base, IndexedSeq, RNA]
        with StrictOptimizedSeqOps[Base, IndexedSeq, RNA] { rna =>

    import RNA._

    // 必ず必要なIndexedSeqOpsのapply実装
    def apply(idx: Int): Base = {
        if (idx < 0 || length <= idx)
            throw new IndexOutOfBoundsException
        Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
    }

    override def className = "RNA"

    override protected def fromSpecific(source: IterableOnce[Base]): RNA =
        RNA.fromSpecific(source)
    override protected def newSpecificBuilder: mutable.Builder[Base, RNA] =
        RNA.newBuilder
    override def empty: RNA = RNA.empty

    // RNAを返すための多重定義メソッド
    def appended(base: Base): RNA = 
        (newSpecificBuilder ++= this += base).result()
    
    def appendedAll(suffix: IterableOnce[Base]): RNA =
        strictOptimizedConcat(suffix, newSpecificBuilder)
    
    def concat(suffix: IterableOnce[Base]): RNA =
        strictOptimizedConcat(suffix, newSpecificBuilder)

    def flatMap(f: Base => IterableOnce[Base]): RNA =
        strictOptimizedFlatMap(newSpecificBuilder, f)
    
    def map(f: Base => Base): RNA =
        strictOptimizedMap(newSpecificBuilder, f)

    def prepended(base: Base): RNA =
        (newSpecificBuilder += base ++= this).result()
    
    def prependedAll(prefix: IterableOnce[Base]): RNA =
        (newSpecificBuilder ++= prefix ++= this).result()
    
    @inline final def ++ (suffix: IterableOnce[Base]): RNA =
        concat(suffix)
    
    // 処理効率を上げるためのイテレーターの再実装(オプション)
    override def iterator: Iterator[Base] =
        new AbstractIterator[Base] {
            private var i = 0
            private var b = 0
            def hasNext: Boolean = i < rna.length
            def next(): Base = {
                b = if (i % N == 0) groups(i / N) else b >>> S
                i += 1
                Base.fromInt(b & M)
            }
        }
}

object RNA extends SpecificIterableFactory[Base, RNA] {
    private val S = 2                   // 塩基識別情報のビット数
    private val M = (1 << S) - 1        // 塩基識別情報を分離するビットマスク
    private val N = 32 / S              // Intに収まる塩基識別情報の数

    def fromSeq(buf: collection.Seq[Base]): RNA = {
        val groups = new Array[Int]((buf.length + N - 1) / N)
        for (i <- 0 until buf.length)
            groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
        new RNA(groups, buf.length)
    }

    // SPecificIterableFactoryが必要とする
    // ファクトリーメソッドの実装
    def empty: RNA = fromSeq(Seq.empty)

    def newBuilder: mutable.Builder[Base, RNA] =
        mutable.ArrayBuffer.newBuilder[Base].mapResult(fromSeq)
    
    def fromSpecific(it: IterableOnce[Base]): RNA = it match {
        case seq: collection.Seq[Base] => fromSeq(seq)
        case _ => fromSeq(mutable.ArrayBuffer.from(it))
    }
}

List(U, A, G, C).to(RNA)
