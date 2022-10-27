object HelloArg {
    def main(args: Array[String]): Unit = {
        // 第1引数にhelloと声をかけよう
        println("Hello, " + args(0) + "!")
    }
}
