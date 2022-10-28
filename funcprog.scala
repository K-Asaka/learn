object FuncProg {
    def main(args: Array[String]): Unit = {
        // printArgs(args)
        println(formatArgs(args))

        // テスト
        val res = formatArgs(Array("zero", "one", "two"))
        assert(res == "zero\none\ntwo")
    }

    // def printArgs(args: Array[String]): Unit = {
    //     var i = 0
    //     while (i < args.length) {
    //         println(args(i))
    //         i += 1
    //     }
    // }

    // def printArgs(args: Array[String]): Unit = {
    //     for (arg <- args)
    //         println(arg)
    // }

    // def printArgs(args: Array[String]): Unit = {
    //     args.foreach(println)
    // }

    // 副作用もvarもない関数
    def formatArgs(args: Array[String]) = args.mkString("\n")

}