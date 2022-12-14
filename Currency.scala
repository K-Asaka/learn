// Currencyクラスの最初の(誤りのある)設計
// abstract class Currency {
//     val amount: Long
//     def designation: String
//     override def toString = s"$amount $designation"
//     // def + (that: Currency): Currency = ...
//     // def * (x: Double): Currency = ...
// }
// Currencyクラスの第2の(まだ不完全な)設計
// abstract class AbstractCurrency {
//     type Currency <: AbstractCurrency       // 抽象型
//     def make(amount: Long): Currency        // ファクトリーメソッド
//     val amount: Long
//     def designation: String
//     override def toString = s"$amount $designation"
//     def + (that: Currency): Currency = new Currency {
//         val amount = this.amount + that.amount
//     }
//     //def * (x: Double): Currency = ...
// }
abstract class CurrencyZone {
    type Currency <: AbstractCurrency
    def make(x: Long): Currency
    abstract class AbstractCurrency {
        val amount: Long
        def designation: String

        def + (that: Currency): Currency = 
            make(this.amount + that.amount)
        def * (x: Double): Currency =
            make((this.amount * x).toLong)
        def - (that: Currency): Currency =
            make(this.amount - that.amount)
        def / (that: Double) =
            make((this.amount / that).toLong)
        def / (that: Currency) =
            this.amount.toDouble / that.amount
        
        def from(other: CurrencyZone#AbstractCurrency): Currency =
            make(math.round(
                other.amount.toDouble
                * Converter.exchangeRate(other.designation)(this.designation))
            )
        
        private def decimals(n: Long): Int =
            if (n == 1) 0 else 1 + decimals(n / 10)
        
        override def toString =
            ((amount.toDouble / CurrencyUnit.amount.toDouble)
            formatted ("%." + decimals(CurrencyUnit.amount) + "f")
            + " " + designation)
    }

    val CurrencyUnit: Currency
}

// new Currency {
//     val amount = 79L
//     def designation = "USD"
// }

//abstract class Dollar extends Currency {
// abstract class Dollar extends AbstractCurrency {
//     def designation = "USD"
// }

// abstract class Euro extends AbstractCurrency {
//     def designation = "Euro"
// }

object US extends CurrencyZone {
    abstract class Dollar extends AbstractCurrency {
        def designation = "USD"
    }
    type Currency = Dollar
    def make(cents: Long) = new Dollar {
        val amount = cents
    }
    val Cent = make(1)
    val Dollar = make(100)
    val CurrencyUnit = Dollar
}

object Europe extends CurrencyZone {
    abstract class Euro extends AbstractCurrency {
        def designation = "EUR"
    }
    type Currency = Euro
    def make(cents: Long) = new Euro {
        val amount = cents
    }
    val Cent = make(1)
    val Euro = make(100)
    val CurrencyUnit = Euro
}

object Japan extends CurrencyZone {
    abstract class Yen extends AbstractCurrency {
        def designation = "JPY"
    }
    type Currency = Yen
    def make(yen: Long) = new Yen {
        val amount = yen
    }
    val Yen = make(1)
    val CurrencyUnit = Yen
}

object Converter {
    var exchangeRate = Map(
        "USD" -> Map("USD" -> 1.0   , "EUR" -> 0.7596, "JPY" -> 1.211, "CHF" -> 1.223),
        "EUR" -> Map("USD" -> 1.316 , "EUR" -> 1.0   , "JPY" -> 1.594, "CHF" -> 1.623),
        "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272, "JPY" -> 1.0  , "CHF" -> 1.018),
        "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160, "JPY" -> 0.982, "CHF" -> 1.0  )
    )
}


val yen = Japan.Yen from US.Dollar * 100
val euro = Europe.Euro from yen
val doll = US.Dollar from euro
println(yen)
println(euro)
println(doll)

println(US.Dollar * 100 + doll)
// println(US.Dollar + Europe.Euro)     // エラー
