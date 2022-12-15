val xs = List(1, 2, 3)
var ys: List[Any] = List(1, 2, 3)

abstract class Fruit
class Apple extends Fruit
class Orange extends Fruit

val apples = new Apple :: Nil
val fruits = new Orange :: apples
