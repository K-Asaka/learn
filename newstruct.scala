import java.io._

object NewStruct {

    def twice(op: Double => Double, x: Double) = op(op(x))

    // def withPrintWriter(file: File, op: PrintWriter => Unit) = {
    def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
        val writer = new PrintWriter(file)
        try {
            op(writer)
        } finally {
            writer.close()
        }
    }

    def main(args: Array[String]) = {
        println(twice(_ + 1, 5))

        // withPrintWriter(
        //     new File("date.txt"),
        //     writer => writer.println(new java.util.Date)
        // )
        var file = new File("date.txt")
        withPrintWriter(file) { writer =>
            writer.println(new java.util.Date)}
    }
}