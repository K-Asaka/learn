import scala.collection.mutable

object SetMutProg {
    def main(args: Array[String]): Unit = {
        val movieSet = mutable.Set("Hitch", "Poltergeist")
        movieSet += "Shrek"     // movieSet.+=("Shrek")
        println(movieSet)
    }
}
