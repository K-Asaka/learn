val it = Iterator("a", "number", "of", "words")
val x = it.map (_.length)
it.hasNext
x foreach println
it.hasNext

val it2 = Iterator("a", "number", "of", "words")
it2 dropWhile (_.length < 2)
it2.next()

val (itt1, itt2) = it.duplicate

// これでは動作しない
// def skipEmptyWordsNOT(it: Iterator[String]) = {
//     while (it.next().isEmpty) {}
// }
def skipEmptyWords(it: BufferedIterator[String]) = {
    while (it.head.isEmpty) { it.next() }
}

val it3 = Iterator(1, 2, 3, 4)
val bit = it3.buffered
bit.head
bit.next()
bit.next()
