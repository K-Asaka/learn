object ClientCode {
    def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
    // def containsNeg(nums: List[Int]): Boolean = {
    //     var exists = false
    //     for (num <- nums)
    //         if (num < 0)
    //             exists = true
    //     exists
    // }

    def containsOdd(nums: List[Int]): Boolean = nums.exists(_ % 2 == 1)
    // def containsOdd(nums: List[Int]): Boolean = {
    //     var exists = false
    //     for (num <- nums)
    //         if (num % 2 == 1)
    //             exists = true
    //     exists
    // }

    def main(args: Array[String]) = {
        println("Neg: " + containsNeg(List(1, 2, 3, 4)))
        println("Neg: " + containsNeg(List(1, 2, -3, 4)))
        println("Neg: " + containsNeg(Nil))
        println("Neg: " + containsNeg(List(0, -1, -2)))

        println("Odd: " + containsOdd(List(2, 4, 5, 6)))
        println("Odd: " + containsOdd(List(2, 4, 6, 8)))
        println("Odd: " + containsOdd(Nil))
        println("Odd: " + containsOdd(List(0, -2, -4, -6)))
        println("Odd: " + containsOdd(List(0, -1, -3, -5)))
    }
}