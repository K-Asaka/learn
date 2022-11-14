import java.net.URL
import java.net.MalformedURLException

object TryCatch4 {
    def main(args: Array[String]): Unit = {
        val url1 = urlFor("http://www.google.co.jp")
        val url2 = urlFor("aaa@mail.local")
        println("url1: " + url1)
        println("url2: " + url2)
    }

    def urlFor(path: String) =
        try {
            new URL(path)
        } catch {
            case e: MalformedURLException =>
                new URL("https://www.scala-lang.org")
        }
}