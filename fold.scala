val words = List("the", "quick", "brown", "fox")

def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)
def product(xs: List[Int]): Int = xs.foldLeft(1)(_ + _)
def flattenLeft[T](xss: List[List[T]]) =
    xss.foldLeft(List[T]())(_ ::: _)
def flattenRight[T](xss: List[List[T]]) =
    xss.foldRight(List[T]())(_ ::: _)
def reverseLeft[T](xs: List[T]) = 
    xs.foldLeft(List[T]()) { (ys, y) => y :: ys }

words.foldLeft("")(_ + " " + _)
words.tail.foldLeft(words.head)(_ + " " + _)
List(1, -3, 4, 2, 6) sortWith (_ < _)
words sortWith (_.length > _.length)
