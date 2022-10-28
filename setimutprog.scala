import scala.collection.immutable.HashSet

object SetImutProg {
    def main(args: Array[String]): Unit = {
        val hashSet = HashSet("Tomatoes", "Chilies")
        println(hashSet + "Coriander")
    }
}
