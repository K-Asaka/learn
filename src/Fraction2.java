class Fraction2 extends FractionOrigin {
    Fraction2() {
        super();
    }

    Fraction2(int n, int d) {
        super(n, d);
    }

    void add (Fraction2 f) {
        numerator = numerator * f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    void add(int n) {
        numerator = numerator + denominator * n;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }
}
