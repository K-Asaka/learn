object ProtectedSample {
    class Super {
        protected def f() = { println("f") }
    }
    class Sub extends Super {
        f()
    }
    class Other {
        //(new Super).f() // エラー: fにはアクセスできない
    }

    def main(args: Array[String]) = {
        val c = new Super
        //c.f()     // エラー
        val c1 = new Sub
    }
}