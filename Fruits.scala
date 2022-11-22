package bobsdelights

abstract class Fruit(
    val name: String,
    val color: String
)

object Fruits {
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = List(Apple, Orange, Pear)
}


// import bobsdelights.Fruit
// import bobsdelights._
// import bobsdelights.Fruits._
// import Fruits.{ Apple => McIntosh, Orange }
// Pear以外をインポートし、AppleはMcIntoshという名前でインポート
import Fruits.{ Pear => _, Apple => McIntosh, _}


object FruitsSample {
    def showFruit(fruit: Fruit) = {
        import fruit._
        println(name + "s are " + color)
    }
    def main(args: Array[String]) = {
        //showFruit(Apple)
        showFruit(McIntosh)
        showFruit(Orange)
        //showFruit(Pear)
    }
}