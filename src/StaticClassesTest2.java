class StaticClassesTest2 {
    public static void main(String[] args) {
        StaticClasses sc = new StaticClasses();

        StaticClasses.Inner1 si1 = new StaticClasses.Inner1();
        si1.sayHello();

        StaticClasses.Inner2 si2 = sc.new Inner2();
        si2.sayHello();
    }
}
