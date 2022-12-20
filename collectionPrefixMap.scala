import scala.collection._

class PrefixMap[A] extends mutable.Map[String, A]
        with mutable.MapOps[String, A, mutable.Map, PrefixMap[A]]
        with StrictOptimizedIterableOps[(String, A), mutable.Iterable, PrefixMap[A]] {
    
    private var suffixes: immutable.Map[Char, PrefixMap[A]] =
        immutable.Map.empty
    
    private var value: Option[A] = None

    def get(s: String): Option[A] =
        if (s.isEmpty) value
        else suffixes get (s(0)) flatMap (_.get(s substring 1))
    
    def addOne(kv: (String, A)): this.type = {
        withPrefix(kv._1).value = Some(kv._2)
        this
    }

    def subtractOne(s: String): this.type = {
        if (s.isEmpty) { val prev = value; value = None; prev }
        else suffixes get (s(0)) flatMap (_.remove(s substring 1))
        this
    }

    def withPrefix(s: String): PrefixMap[A] =
        if (s.isEmpty) this
        else {
            val leading = s(0)
            suffixes get leading match {
                case None =>
                    suffixes = suffixes + (leading -> empty)
                case _ =>
            }
            suffixes(leading) withPrefix (s substring 1)
        }
    
    def iterator: Iterator[(String, A)] =
        (for (v <- value.iterator) yield ("", v)) ++
            (for ((chr, m) <- suffixes.iterator;
                (s, v) <- m.iterator) yield (chr +: s, v))
    
    override def className = "PrefixMap"

    // PrefixMapを返すための多重定義
    def map[B](f: ((String, A)) => (String, B)): PrefixMap[B] =
        strictOptimizedMap(PrefixMap.newBuilder[B], f)
    
    def flatMap[B](f: ((String, A)) =>
            IterableOnce[(String, B)]): PrefixMap[B] =
        strictOptimizedFlatMap(PrefixMap.newBuilder[B], f)
    
    // 戻り値の型を変えるためにオーバーライド
    override def concat[B >: A](suffix: IterableOnce[(String, B)]): PrefixMap[B] =
        strictOptimizedConcat(suffix, PrefixMap.newBuilder[B])
    
    // scala.collection.mutable.Clearableで宣言されているメンバー
    override def clear(): Unit = suffixes = immutable.Map.empty

    // scala.collection.IterableOpsで宣言されているメンバー
    override protected def fromSpecific (source: IterableOnce[(String, A)]): PrefixMap[A] =
        PrefixMap.from(coll)
    
    override protected def newSpecificBuilder: mutable.Builder[(String, A), PrefixMap[A]] =
        PrefixMap.newBuilder
    
    override def empty: PrefixMap[A] = new PrefixMap
}

import scala.collection._
import scala.language.implicitConversions

object PrefixMap {
    def empty[A] = new PrefixMap[A]

    def from[A](source: IterableOnce[(String, A)]): PrefixMap[A] =
        source match {
            case pm: PrefixMap[A] => pm
            case _ => (newBuilder[A] ++= source).result()
        }

    def apply[A](kvs: (String, A)*): PrefixMap[A] = from(kvs)

    def newBuilder[A]: mutable.Builder[(String, A), PrefixMap[A]] =
        new mutable.GrowableBuilder[(String, A), PrefixMap[A]](empty)
    
    implicit def toFactory[A](self: this.type): Factory[(String, A), PrefixMap[A]] =
        new Factory[(String, A), PrefixMap[A]] {
            def fromSpecific(source: IterableOnce[(String, A)]): PrefixMap[A] =
                self.from(source)
            def newBuilder: mutable.Builder[(String, A), PrefixMap[A]] =
                self.newBuilder
        }
}


val m = PrefixMap("abc" -> 0, "abd" -> 1, "al" -> 2, "all" -> 3, "xy" -> 4)
m withPrefix "a"

val x = PrefixMap("hello" -> 5, "hi" -> 2)
x += "foo" -> 3
