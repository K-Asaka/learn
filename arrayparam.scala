object ArrayParam {
    def main(args: Array[String]): Unit = {
        // インスタンスの生成
        val big = new java.math.BigInteger("12345")
        println(big)

        // 配列の型パラメータの内容の指定
        //val greetStrings: Array[String] = new Array[String](3)
        val greetStrings = new Array[String](3)
        // 配列の作成・初期化
        //val numNames2 = Array.apply("zero", "one", "two")
        val numNames2 = Array("zero", "one", "two")
        
        greetStrings(0) = "Hello"       // greetStrings.update(0, "Hello")
        greetStrings(1) = ", "          // greetStrings.update(1, ", ")
        greetStrings(2) = "world!\n"    // greetStrings.update(2, "world!\n")

        for (i <- 0 to 2)   // (0).to(2)
            print(greetStrings(i))      // print(greetStrings.apply(i))
        
        for (i <- 0 to 2)
            print(numNames2(i) + " ")
    }
}