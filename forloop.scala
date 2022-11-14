object ForLoop {
    def main(args: Array[String]): Unit = {
        val filesHere = (new java.io.File(".")).listFiles
        for (file <- filesHere)
            println(file)
    }
}