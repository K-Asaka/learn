object Color extends Enumeration {
    // val Red = Value
    // val Green = Value
    // val Blue = Value
    // 以下のように書いても上記と同じ
    val Red, Gree, Blue = Value
}

object Direction extends Enumeration {
    // val North, East, South, West = Value
    val North = Value("North")
    val East = Value("East")
    val South = Value("South")
    val West = Value("West")
}

for (d <- Direction.values) println(d)
Direction.East.id
Direction(1)
