object ListProg {
    def main(args: Array[String]): Unit = {
        val oneTwoThree = List(1, 2, 3)
        val oneTwo = List(1, 2)
        val threeFour = List(3, 4)
        val oneTwoThreeFour = oneTwo ::: threeFour
        // println(oneTwo + " and " + threeFour + " were not mutated.")
        // println("Thus, " + oneTwoThreeFour + " is a new list.")
        print(oneTwo); print(" and "); print(threeFour); println(" were not mutated.")
        print("Thus, "); print(oneTwoThreeFour); println(" is a new list.")

        val twoThree = List(2, 3)
        val oneTwoThree2 = 1 :: twoThree    // ::は右被演算子twoThreeのメソッド
        println(oneTwoThree2)

        val oneTwoThree3 = 1 :: 2 :: 3 :: Nil   // 最後にNilを置くことで初期化
        println(oneTwoThree3)

    }
}