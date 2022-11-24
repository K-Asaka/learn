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
