abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length

    def demo() = {
        println("Element's implementation invoked")
    }
}

class ArrayElement(
    val contents: Array[String]
) extends Element {
        override def demo() = {
        println("ArrayElement's implementation invoked")
    }
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width = s.length
    override def height = 1

    override def demo() = {
        println("LineElement's implementation invoked")
    }
}

class UniformElement (
    ch: Char,
    override val width: Int,
    override val height: Int
) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
}
