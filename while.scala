object WhileLoop {
    def main(args: Array[String]): Unit = {
        val ans = gcdLoop(42, 66)
        println("ans = " + ans)
    }

    def gcdLoop(x: Long, y: Long): Long = {
        var a = x
        var b = y
        while (a != 0) {
            val temp = a
            a = b % a
            b = temp
        }
        b
    }
}