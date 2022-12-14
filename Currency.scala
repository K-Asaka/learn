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
        override def toString = s"$amount $designation"
        def + (that: Currency): Currency = 
            make(this.amount + that.amount)
        def * (x: Double): Currency =
            make((this.amount * x).toLong)
    }
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
    def make(x: Long) = new Dollar { val amount = x }
}
