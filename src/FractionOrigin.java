class FractionOrigin {
    int numerator;
    int denominator;

    FractionOrigin() {
        numerator = 0;
        denominator = 1;
    }

    FractionOrigin(int n, int d) {
        numerator = n;
        denominator = d;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
