object PA {
    def main(args: Array[String]): Unit = {
        //args.foreach(arg => println(arg))
        // 型を明示する場合
        // args.foreach((arg: String) => println(arg))
        // 関数リテラルが1個のパラメータをとる1個の文から構成される場合は
        // 引数を明示的に指定しなくて済む
        args.foreach(println)
    }
}