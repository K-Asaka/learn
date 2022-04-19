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

    public String toString() {
        return numerator + "/" + denominator;
    }
}
