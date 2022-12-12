object Demo {
    val x = { println("initializing x"); "done" }
    lazy val y = { println("initializing y"); "done" }
}

Demo
println("-----")
Demo.x
Demo.y