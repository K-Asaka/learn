import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.must.Matchers._
import Element.elem

class ElementSpec extends AnyWordSpec 
        with ScalaCheckPropertyChecks {
    "elem result" must {
        "have passed width" in {
            forAll { (w: Int) =>
                whenever (w > 0) {
                    elem('x', w % 100, 3).width must equal (w % 100)
                }
            }
        }
    }
}
