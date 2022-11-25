
def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
}

def varmatch(expr: Any) = expr match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
}

import math.{E, Pi}
def constmatch(E: Any) = E match {
    case Pi => "strange math? Pi = " + Pi
    case _  => "OK"
}

def constvarmatch(E: Any) = E match {
    case pi => "strange math? Pi = " + pi
    //case _  => "OK"
}

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

def constructormatch(expr: Any) = expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ => 
}

def sequencematch(expr: Any) = expr match {
    case List(0, _, _) => println("found it")
    case _ =>
}

def sequencevarmatch(expr: Any) = expr match {
    case List(0, _*) => println("found it")
    case _ =>
}

def tupleDemo(expr: Any) =
    expr match {
        case (a, b, c) => println("matched " + a + b + c)
        case _ =>
    }

def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
}

def isIntIntMap(x: Any) = x match {
    case m: Map[Int, Int] => true
    case _ => false
}

def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _ => "no"
}

def varbindmatch(expr: Any) = expr match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
}

def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y =>
        BinOp("*", x, Number(2))
    case _ => e
}

def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) =>
        simplifyAll(e)      // '-'は元の数の反数
    case BinOp("+", e, Number(0)) =>
        simplifyAll(e)      // '0'は'+'の単位元
    case BinOp("*", e, Number(1)) =>
        simplifyAll(e)      // '1'は'*'の単位元
    case UnOp(op, e) =>
        UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) =>
        BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
}

def simplifyBad(expr: Expr): Expr = expr match {
    case UnOp(op, e) => UnOp(op, simplifyBad(e))
    case UnOp("-", UnOp("-", e)) => e
}