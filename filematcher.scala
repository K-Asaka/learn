object FileMatcher {
    private def filesHere = (new java.io.File(".")).listFiles

    private def filesMatching(matcher: String => Boolean) =
        for (file <- filesHere; if matcher(file.getName))
            yield file

    def filesEnding(query: String) =
        filesMatching(_.endsWith(query))
        // for (file <- filesHere; if file.getName.endsWith(query))
        //     yield file

    def filesContaining(query: String) =
        filesMatching(_.contains(query))
        // for (file <- filesHere; if file.getName.contains(query))
        //     yield file
    
    def filesRegex(query: String) =
        filesMatching(_.matches(query))    
        // for (file <- filesHere; if file.getName.matches(query))
        //     yield file
    
    def main(args: Array[String]) = {
        for (f <- filesEnding(".scala"))
            println(f)
    }
}
