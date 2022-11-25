val second: List[Int] => Int = {
    case x :: y :: _ => y
}

val second2: PartialFunction[List[Int], Int] = {
    case x :: y :: _ => y
}
