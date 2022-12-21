val contents = (new Wild).contents
contents.size()

import scala.collection.mutable
import java.util.Collection

abstract class SetAndType {
    type Elem
    val set: mutable.Set[Elem]
}

def javaSet2ScalaSet[T](jset: Collection[T]): SetAndType = {
    val sset = mutable.Set.empty[T]  // Tという名前で呼べるようになった

    val iter = jset.iterator
    while (iter.hasNext)
        sset += iter.next()
    
    new SetAndType {
        type Elem = T
        val set = sset
    }
}


