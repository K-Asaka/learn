val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
}