object MyAssert {
    var assertionsEnabled = false

    def myAssert(predicate: () => Boolean) =
        if (assertionsEnabled && !predicate())
            throw new AssertionError

    def byNameAssert(predicate: => Boolean) =
        if (assertionsEnabled && !predicate)
            throw new AssertionError

    def boolAssert(predicate: Boolean) =
        if (assertionsEnabled && !predicate)
            throw new AssertionError
    
    def main(args: Array[String]) = {
        // myAssert(() => 5 > 3)
        myAssert(() => 5 > 3)
        byNameAssert(5 > 3)
        boolAssert(5 > 3)
        // boolAssert(5 / 0 == 0)
        byNameAssert(5 / 0 == 0)   
    }
}
