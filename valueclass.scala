object ValueClass {
    class Dollars(val amount: Int) extends AnyVal {
        override def toString() = "$" + amount
    }

    class SwissFrancs(val amount: Int) extends AnyVal {
        override def toString() = s"$amount CHF"
    }

    def main(args: Array[String]) = {
        val money = new Dollars(1000000)
        println(money)
        println(money.amount)

        val dollars = new Dollars(1000)
        println(dollars)

        val francs = new SwissFrancs(1000)
        println(francs)

    }
}