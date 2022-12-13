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

// class Fish extends Food
// val bessy: Animal = new Cow
// bessy eat(new Fish)

class DogFood extends Food
class Dog extends Animal {
    type SuitableFood = DogFood
    override def eat(food: DogFood) = {}
}

val bessy = new Cow
val lassie = new Dog
// lassie eat (new bessy.SuitableFood)   // 互換性がないためエラー
val bootsie = new Dog
lassie eat (new bootsie.SuitableFood)
