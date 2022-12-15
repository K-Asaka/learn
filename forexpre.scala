case class Person(name: String, isMale: Boolean, children: Person*)

val lara = Person("Lara", false)
val bob = Person("Bob", true)
val julie = Person("Julie", false, lara, bob)
val persons = List(lara, bob, julie)

persons filter (p => !p.isMale) flatMap (p => 
    (p.children map (c => (p.name, c.name))))

persons withFilter (p => !p.isMale) flatMap (p =>
    (p.children map (c => (p.name, c.name))))

for (p <- persons; if !p.isMale; c <- p.children)
    yield (p.name, c.name)


for (p <- persons; n = p.name; if (n startsWith "To"))
yield n
for {
    p <- persons            // ジェネレーター
    n = p.name              // 定義
    if (n startsWith "To")  // フィルター
} yield n
for (x <- List(1, 2); y <- List("one", "two"))
    yield (x, y)
