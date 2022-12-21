object FindTests {
    def main(args: Array[String]) = {
        for {
            method <- Tests.getClass.getMethods
            if method.getName.startsWith("test")
            if method.getAnnotation(classOf[Ignore]) == null
        } {
            println("found a test method: " + method)
        }
    }
}
