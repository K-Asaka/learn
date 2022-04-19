class Fraction2 extends Fraction {
    void add (Fraction f) {
        numerator = numerator * f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    void add(int n) {
        numerator = numerator + denominator * n;
    }
}
