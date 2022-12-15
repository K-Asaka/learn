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

def maxList[T](elements: List[T])
        (implicit ordering: Ordering[T]): T =
    elements match {
        case List() =>
            throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
            val maxRest = maxList(rest)     // 暗黙のうちに(ordering)が追加される
            if (ordering.gt(x, maxRest)) x  // このorderingはまだ明示しなければならない
            else maxRest
    }
