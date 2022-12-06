val words = List("the", "quick", "brown", "fox")
val abcde = List('a', 'b', 'c', 'd','e')

def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)
def product(xs: List[Int]): Int = xs.foldLeft(1)(_ + _)
def flattenLeft[T](xss: List[List[T]]) =
    xss.foldLeft(List[T]())(_ ::: _)
def flattenRight[T](xss: List[List[T]]) =
    xss.foldRight(List[T]())(_ ::: _)
def reverseLeft[T](xs: List[T]) = 
    xs.foldLeft(List[T]()) { (ys, y) => y :: ys }
def msortSwapped[T](xs: List[T])
        (less: (T, T) => Boolean): List[T] = {
    // msortと実装は同じだがパラメーターは逆になっている
    def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
            if (less(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
    }
    val n = xs.length / 2
    if (n == 0) xs
    else {
        val (ys, zs) = xs splitAt n
        merge(msort(less)(ys), msort(less)(zs))
    }
}

words.foldLeft("")(_ + " " + _)
words.tail.foldLeft(words.head)(_ + " " + _)
List(1, -3, 4, 2, 6) sortWith (_ < _)
words sortWith (_.length > _.length)

List.apply(1, 2, 3)
List.range(1, 5)
List.range(1, 9, 2)
List.range(9, 1, -3)
List.fill(5)('a')
List.fill(3)("hello")
List.fill(2, 3)('b')
val squares = List.tabulate(5)(n => n * n)
val multiplication = List.tabulate(5, 5)(_ * _)
List.concat(List('a', 'b'), List('c'))
List.concat(List(), List('b'), List('c'))
List.concat()
(List(10, 20) zip List(3, 4, 5)).map { case (x, y) => x * y }
(List(10, 20) lazyZip List(3, 4, 5)).map(_ * _)
(List("abc", "de") lazyZip List(3, 2)).forall(_.length == _)
(List("abc", "de") lazyZip List(3, 2)).exists(_.length != _)
msort((x: Char, y: Char) => x > y)(abcde)
abcde sortWith (_ > _)
// msort(_ > _)(abcde) // エラー
msort[Char](_ > _)(abcde)
msortSwapped(abcde)(_ > _)
