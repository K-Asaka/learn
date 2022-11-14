object ForLoop7 {
    def main(args: Array[String]): Unit = {
        val filesHere = (new java.io.File(".")).listFiles
        val forLineLengths = 
            for {
                file <- filesHere
                if file.getName.endsWith(".scala")
                line <- fileLines(file)
                trimmed = line.trim
                if trimmed.matches(".*for.*")
            } yield trimmed.length
        for (len <- forLineLengths)
            println(len)
    }

    def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file, "UTF-8").getLines().toArray
}