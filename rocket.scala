class Rocket {
    import Rocket.fuel
    private def canGoHomeAagin = fuel > 20
}

object Rocket {
    private def fuel = 10
    def chooseStartegy(rocket: Rocket) = {
        if (rocket.canGoHomeAagin)
            goHome()
        else
            pickAStar()
    }
    def goHome() = { println("go home") }
    def pickAStar() = { println("pick a start") }
}

object RocketSample {
    def main(args: Array[String]) = {
        val r = new Rocket
        Rocket.chooseStartegy(r)
    }
}