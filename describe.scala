def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
    case _ => throw new RuntimeException    // 決して起きない
}
