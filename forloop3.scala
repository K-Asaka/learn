object ForLoop3 {
    def main(args: Array[String]): Unit = {
        val filesHere = (new java.io.File(".")).listFiles
        for (
            file <- filesHere
            if file.isFile
            if file.getName.endsWith(".scala"))
            println(file)
    }
}