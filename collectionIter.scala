val it = Iterator("a", "number", "of", "words")
val x = it.map (_.length)
it.hasNext
x foreach println
it.hasNext

val it2 = Iterator("a", "number", "of", "words")
it2 dropWhile (_.length < 2)
it2.next()

val (itt1, itt2) = it.duplicate
