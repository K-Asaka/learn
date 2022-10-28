object MapImutProg {
    def main(args: Array[String]): Unit = {
        val romanNumeral = Map(
            1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
        )
        println(romanNumeral(4))
    }
}