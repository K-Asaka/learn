def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e   // 負の負は元のまま
    case BinOp("+", e, Number(0)) => e   // 0の加算は元のまま
    case BinOp("*", e, Number(1)) => e  // 1の乗算は元のまま
    case _ => expr
}

def m1(expr: Expr): Unit = expr match {
    case BinOp(op, left, right) =>
        println(s"$expr is a binary operation")
    case _ =>
}

def m2(expr: Expr): Unit = expr match {
    case BinOp(_, _, _) =>
        println(s"$expr is a binary operation")
    case _ => println("It's something else")
}