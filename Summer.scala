import ChecksumAccumulator.calculate

object Summer {
    def main(args: Array[String]): Unit = {
        for (arg <- args)
            println(arg + ": " + calculate(arg))
    }
}

// scalac ChecksumAccumulator.scala Summer.scala
// または
// fsc ChecksumAccumulator.scala Summer.scala
// fscはWindows版では確認できず

// 実行
// scala Summer of love
