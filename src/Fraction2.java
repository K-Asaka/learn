class Fraction2 extends FractionOrigin {
    Fraction2() {
        numerator = 0;
        denominator = 1;
    }

    Fraction2(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    void add (Fraction2 f) {
        numerator = numerator * f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    void add(int n) {
        numerator = numerator + denominator * n;
    }
}
