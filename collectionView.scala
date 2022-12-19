// def lazyMap[T, U](coll: Iterable[T], f: T => U) =
//     new Iterable[U] {
//         def iterator = coll.iterator map f
//     }

val v = Vector(1 to 10: _*)
v map (_ + 1) map (_ * 2)

(v.view map (_ + 1) map (_ * 2)).to(Vector)

val vv = v.view
val x = vv map (_ + 1)
val x2 = x map (_ * 2)
x2.to(Vector)


def isPalindrome(x: String) = x == x.reverse
def findPalindrome(s: Iterable[String]) = s find isPalindrome

findPalindrome(words take 1000000)
findPalindrome(words.view take 1000000)
