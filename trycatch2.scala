import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

object TryCatch2 {
    def main(args: Array[String]): Unit = {
        try {
            val f = new FileReader("input.txt")
        } catch {
            case ex: FileNotFoundException =>   // ファイルなしエラーを処理
                println("File not found.")
            case ex: IOException => // その他のI/Oエラーを処理
                println("I/O error.")
        }
    }
}