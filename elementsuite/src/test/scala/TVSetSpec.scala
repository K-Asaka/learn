import org.scalatest._
import org.scalatest.featurespec.AnyFeatureSpec

class TVSetSpec extends AnyFeatureSpec with GivenWhenThen {
    Feature("TV power button") {
        Scenario("User presses power button when TV is off") {
            Given("a TV set that is switched off")
            When("the power button is pressed")
            pending
        }
    }
}