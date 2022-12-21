import scala.util.matching.Regex

// val Decimal = new Regex("(-)?(\\d+)(\\.\\d*)?")
// val Decimal2 = """(-)?(\d+)(\.\d*)?""".r

val Decimal = """(-)?(\d+)(\.\d*)?""".r

val input = "for -1.0 to 99 by 3"
for (s <- Decimal findAllIn input)
Decimal findFirstIn input
Decimal findPrefixOf input
