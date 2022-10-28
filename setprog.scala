object SetProg {
    def main(args: Array[String]): Unit = {
        var jetSet = Set("Boeing", "Airbus")
        jetSet += "Lear"
        println(jetSet.contains("Cessna"))
    }
}