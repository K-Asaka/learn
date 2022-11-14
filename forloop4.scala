object ForLoop4 {

    def main(args: Array[String]): Unit = {
        grep(".*gcd.*")
    }

    def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file, "UTF-8").getLines().toArray
    
    def grep(pattern: String) = {
        val filesHere = (new java.io.File(".")).listFiles
        for (
            file <- filesHere;
            if file.getName.endsWith(".scala");
            line <- fileLines(file);
            if line.trim.matches(pattern)
        ) println(s"$file: ${line.trim}")
    }
}