object PrivateSample {
    class Outer {
        class Inner {
            private def f() = { println("f") }
            class InnerMost {
                f() // OK
            }
        }
        //(new Inner).f()     // エラー: fにはアクセスできない
    }

    def main(args: Array[String]) = {
        val c = new Outer
        val c1 = new c.Inner
        new c1.InnerMost
    }
}