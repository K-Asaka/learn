import java.io.FileReader

object TryCatch3 {
    def main(args: Array[String]): Unit = {
        val file = new FileReader("trycatch3.scala")
        try {
            // ファイルを使う
        } finally {
            println("File close.")
            file.close()    // 確実にファイルをクローズする
        }
    }
}