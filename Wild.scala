val contents = (new Wild).contents
contents.size()

import scala.collection.mutable
val iter = (new Wild).contents.iterator
val set = mutable.Set.empty[???]        // ここにどの型を指定すればよいのか？
while (iter.hasMore)
    set += iter.next()
