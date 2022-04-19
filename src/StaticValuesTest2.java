class StaticValuesTest2 {
    public static void main(String[] args) {
        StaticValues s1 = new StaticValues();
        StaticValues s2 = new StaticValues();

        System.out.println(s1.greet);
        System.out.println(s2.greet);
        s1.greet = "Hello";
        System.out.println(s1.greet);
        System.out.println(s2.greet);
    }
}
