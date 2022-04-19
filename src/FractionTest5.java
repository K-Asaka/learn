class FractionTest5 {
    public static void main(String[] args) {
        Fraction f = new Fraction();

        System.out.println("f=" + f.numerator + "/" + f.denominator);

        f.add(2);
        System.out.println("f=" + f.numerator + "/" + f.denominator);
    }
}
