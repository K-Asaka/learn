trait Abstract {
    type T
    def transform(x: T): T
    val initial: T
    var current: T
}

class Concrete extends Abstract {
    type T = String
    def transform(x: String) = x + x
    val initial = "hi"
    var current = initial
}

abstract class Fruit {
    val v: String       // valueの'v'
    def m: String       // methodの'm'
}

abstract class Apple extends Fruit {
    val v: String
    val m: String       // OK: 'def'は'val'でオーバーライドしてよい
}

abstract class BadApple extends Fruit {
    //def v: String       // エラー: 'val'は'def'でオーバーライドできない
    def m: String
}

trait AbstractTime {
    var hour: Int
    var minute: Int
}

