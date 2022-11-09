class Rational(n: Int, d: Int) {
    require(d != 0)
    override def toString = s"$n/$d"
}
