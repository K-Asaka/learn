class Fraction {
    int numerator;
    int denominator;

    void add(Fraction f) {
        numerator = numerator * f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    void add(int n) {
        numerator = numerator + denominator * n;
    }
}
