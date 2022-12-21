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

class Branch[T] (
    val elem: T,
    val left: Tree[T],
    val right: Tree[T]
) extends Tree[T] {
    override def equals(other: Any) = other match {
        case that: Branch[_] => (that canEqual this) &&
                                this.elem == that.elem &&
                                this.left == that.left &&
                                this.right == that.right
        case _ => false
    }
    // def canEqual(other: Any) = other match {
    //     case that: Branch[_] => true
    //     case _ => false
    // }
    def canEqual(other: Any) = other.isInstanceOf[Branch[_]]
    override def hashCode: Int = (elem, left, right).##
}

val b1 = new Branch[List[String]](Nil, EmptyTree, EmptyTree)
val b2 = new Branch[List[Int]](Nil, EmptyTree, EmptyTree)
b1 == b2
