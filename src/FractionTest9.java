class FractionTest9 {
    public static void main(String[] args) {
        Fraction2 f1 = new Fraction2();
        Fraction2 f2 = new Fraction2();
        f1.numerator = 1;
        f1.denominator = 2;

        f2.numerator = 3;
        f2.denominator = 4;

        System.out.println("f1=" + f1);
        System.out.println("f2=" + f2);

        f1.add(f2);

        System.out.println("f1=" + f1);
    }
}
