object TraitPhilosohpical {
    trait Philosophical {
        def philosophize() = {
            println("I consume memory, therefore I am!")
        }
    }

    class Animal
    trait HasLegs

    // トレイトのミックスイン
    class Frog extends Animal with Philosophical with HasLegs {
        override def toString = "green"
        override def philosophize() = {
            println("It ain't easy being " + toString + "!")
        }
    }

    def main(args: Array[String]) = {
        val frog = new Frog
        println("frog = " + frog)
        frog.philosophize()

        // 型として使った例
        val phil: Philosophical = frog
        println("phil = " + phil)
        phil.philosophize()

        val phrog: Philosophical = new Frog
        println("phrog = " + phrog)
        phrog.philosophize()
    }

}