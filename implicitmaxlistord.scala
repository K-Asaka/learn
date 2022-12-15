def maxListOrdering[T](elements: List[T])
        (ordering: Ordering[T]): T =
    elements match {
        case List() =>
            throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
            val maxRest = maxListOrdering(rest)(ordering)
            if (ordering.gt(x, maxRest)) x
            else maxRest
    }

def maxListImpParm[T](elements: List[T])
        (implicit ordering: Ordering[T]): T =
    elements match {
        case List() =>
            throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
            val maxRest = maxListImpParm(rest)(ordering)
            if (ordering.gt(x, maxRest)) x
            else maxRest
    }

def maxList[T : Ordering](elements: List[T]): T =
    elements match {
        case List() =>
            throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
            val maxRest = maxList(rest)
            if (implicitly[Ordering[T]].gt(x, maxRest)) x
            else maxRest
    }

def printLength(seq: Seq[Int]) = println(seq.length)
implicit def intToRange(i: Int) = 1 to i
implicit def intToDigits(i: Int) =
    i.toString.toList.map(_.toInt)
printLength(12)
