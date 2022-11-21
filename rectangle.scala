import java.awt.Point
object Rectangle {
    class Point(val x: Int, val y: Int)

    trait Rectangular {
        def topLeft: Point
        def bottomRight: Point

        def left = topLeft.x
        def right = bottomRight.x
        def width = right - left
        // もっと多くの幾何学メソッド
    }

    abstract class Component extends Rectangular {
        // その他のメソッド
    }

    class Rectangle(val topLeft: Point, val bottomRight: Point)
        extends Rectangular {
            // その他のメソッド
    }

    def main(args: Array[String]) = {
        val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
        println(rect.left)
        println(rect.right)
        println(rect.width)
    }

}