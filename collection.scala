val colors = List("red", "blue", "green")
colors.head
colors.tail
val fiveInts = new Array[Int](5)
val fiveToOne = Array(5, 4, 3, 2, 1)
fiveInts(0) = fiveToOne(4)
fiveInts

import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
buf += 1
buf += 2
buf
3 +=: buf
buf.toList

import scala.collection.mutable.ArrayBuffer
val buf2 = new ArrayBuffer[Int]()
buf2 += 12
buf2 += 15
buf2
buf2.length
buf2(0)

def hasUpperCase(s: String) = s.exists(_.isUpper)
hasUpperCase("Robert Frost")
hasUpperCase("e e cummings")

import scala.collection.mutable
val mutaSet = mutable.Set(1, 2, 3)

val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")
val words = mutable.Set.empty[String]
for (word <- wordsArray)
    words += word.toLowerCase
words

val map = mutable.Map.empty[String, Int]
map("hello") = 1
map("there") = 2
map
map("hello")

def countWords(text: String) = {
    val counts = mutable.Map.empty[String, Int]
    for (rawWord <- text.split("[ ,!.]+")) {
        val word = rawWord.toLowerCase
        val oldCount =
            if (counts.contains(word)) counts(word)
            else 0
        counts += (word -> (oldCount + 1))
    }
    counts
}

countWords("See Spot run! Run, Spot. Run!")

import scala.collection.immutable.TreeSet
val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
val cs = TreeSet('f', 'u', 'n')

import scala.collection.immutable.TreeMap
var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
tm += (2 -> 'x')
tm

// val people = Set("Nancy", "Jane")    // エラー
var people = Set("Nancy", "Jane")
people += "Bob"
people -= "Jane"
people ++= List("Tom", "Harry")
people

var roughlyPi = 3.0
roughlyPi += 0.1
roughlyPi += 0.04
roughlyPi

List(1, 2, 3)
Set('a', 'b', 'c')

import scala.collection.mutable
mutable.Map("hi" -> 2, "there" -> 5)
Array(1.0, 2.0, 3.0)

import scala.collection.mutable
// val stuff = mutable.Set(42)
val stuff = mutable.Set[Any](42)
stuff += "abracadabra"

val colors2 = List("blue", "yello", "red", "green")

import scala.collection.immutable.TreeSet
// val treeSet = TreeSet(colors)
val treeSet = colors2 to TreeSet

treeSet.toList
treeSet.toArray
