class Fraction {
    int numerator;
    int denominator;

    Fraction() {
        numerator = 0;
        denominator = 1;
    }

    Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    void add(Fraction f) {
        numerator = numerator * f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    void add(int n) {
        numerator = numerator + denominator * n;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
