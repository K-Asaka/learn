import scala.io.StdIn.readLine

object DoWhileLoop {
    def main(args: Array[String]): Unit = {
        var line = ""
        // Scala 3より廃止
        // do {
        //     line = readLine()
        //     println("Read: " + line)
        // } while (line != "")
        while {
            line = readLine()
            line != ""
        } do println("Read: " + line)
    }
}