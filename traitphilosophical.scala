object TraitPhilosohpical {
    trait Philosophical {
        def philosophize() = {
            println("I consume memory, therefore I am!")
        }
    }

    class Animal

    // トレイトのミックスイン
    class Frog extends Animal with Philosophical {
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