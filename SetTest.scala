import org.junit.Test
import org.junit.Assert.assertEquals

class SetTest {

    @Test
    def testMultiAdd = {
        val set = Set() + 1 + 2 + 3 + 1 + 2 + 3
        assertEquals(3, set.size)
    }
}
// $ scala -cp junit-4.3.1.jar:. org.junit.runner.JUnitCore SetTest
