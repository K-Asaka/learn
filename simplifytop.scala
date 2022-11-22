def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e   // 負の負は元のまま
    case BinOp("+", e, Number(0)) => e   // 0の加算は元のまま
    case BinOp("*", e, Number(1)) => e  // 1の乗算は元のまま
    case _ => expr
}
