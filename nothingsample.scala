object NothingSample {
   
    def divide(x: Int, y: Int): Int = 
        if (y != 0) x /y
        else sys.error("can't divide by zero")
    
    def main(args: Array[String]) = {
        divide(1, 0)
    }
}