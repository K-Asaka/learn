class Food
abstract class Animal {
    type SuitableFood <: Food
    def eat(food: SuitableFood): Unit
}

class Grass extends Food
class Cow extends Animal {
    type SuitableFood = Grass
    override def eat(food: Grass) = {}  // コンパイルできない
}

class Fish extends Food
val bessy: Animal = new Cow
bessy eat(new Fish)
