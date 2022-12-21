import scala.util.matching.Regex

val Decimal = new Regex("(-)?(\\d+)(\\.\\d*)?")
val Decimal2 = """(-)?(\d+)(\.\d*)?""".r
