object ForLoop6 {
    def main(args: Array[String]): Unit = {
        for (ret <- scalaFiles)
            println(ret)
    }

    def scalaFiles = 
        val filesHere = (new java.io.File(".")).listFiles
        for {
            file <- filesHere
            if file.getName.endsWith(".scala")
        } yield file
}