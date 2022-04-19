class FractionTest10 {
    public static void main(String[] args) {
        Fraction2 f1 = new Fraction2(1, 2);
        Fraction2 f2 = new Fraction2(3, 4);

        System.out.println("f1=" + f1);
        System.out.println("f2=" + f2);

        f1.add(f2);

        System.out.println("f1=" + f1);
    }
}
