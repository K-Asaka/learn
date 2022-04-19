class Fraction2 extends FractionOrigin {
    Fraction2() {
        super();
    }

    Fraction2(int numerator, int denominator) {
        super(numerator, denominator);
    }

    void add (Fraction2 f) {
        numerator = numerator * f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    void add(int n) {
        numerator = numerator + denominator * n;
    }
}
