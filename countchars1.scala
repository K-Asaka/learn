import scala.io.Source

object CountChars1 {
    def main(args: Array[String]): Unit = {
        if (args.length > 0) {
            for (line <- Source.fromFile(args(0)).getLines())
                println(line.length.toString + " " + line)
        }
        else
            Console.err.println("Please enter filename")
    }
}