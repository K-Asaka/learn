object TraitPhilosohpical {
    trait Philosophical {
        def philosophize() = {
            println("I consume memory, therefore I am!")
        }
    }

    // トレイトのミックスイン
    class Frog extends Philosophical {
        override def toString = "green"
    }

    def main(args: Array[String]) = {
        val frog = new Frog
        println("frog = " + frog)
        frog.philosophize()

        // 型として使った例
        val phil: Philosophical = frog
        println("phil = " + phil)
        phil.philosophize()
    }

}