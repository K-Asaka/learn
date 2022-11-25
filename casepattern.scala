
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
