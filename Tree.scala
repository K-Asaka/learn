trait Tree[+T] {
    def elem: T
    def left: Tree[T]
    def right: Tree[T]
}

object EmptyTree extends Tree[Nothing] {
    def elem =
        throw new NoSuchElementException("EmptyTree.elem")
    def left =
        throw new NoSuchElementException("EmptyTree.left")
    def right =
        throw new NoSuchElementException("EmptyTree.right")
}

class Branch[+T] (
    val elem: T,
    val left: Tree[T],
    val right: Tree[T]
) extends Tree[T] {
    override def equals(other: Any) = other match {
        case that: Branch[T] => this.elem == that.elem &&
                                this.left == that.left &&
                                this.right == that.right
        case _ => false
    }
}

val b1 = new Branch[List[String]](Nil, EmptyTree, EmptyTree)
val b2 = new Branch[List[Int]](Nil, EmptyTree, EmptyTree)
b1 == b2
