class FractionTest5 {
    public static void main(String[] args) {
        Fraction f = new Fraction();

        f.numerator = 1;
        f.denominator = 2;

        System.out.println("f=" + f.numerator + "/" + f.denominator);

        f.add(3, 1);
        System.out.println("f=" + f.numerator + "/" + f.denominator);
    }
}
