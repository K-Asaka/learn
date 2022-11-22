import org.scalatest.funsuite.AnyFunSuite
import Element.elem

class ElementSuite extends AnyFunSuite {
    test("elem result should have passed width") {
        val ele = elem('x', 2, 3)
        assert(ele.width == 2)
        assertResult(2) {
            ele.width
        }
        // assertThrows[IllegalArgumentException] {
        //     elem('x', -2, 3)
        // }
        val caught =
            intercept[ArithmeticException] {
                1 / 0
            }
        assert(caught.getMessage == "/ by zero")
    }
}