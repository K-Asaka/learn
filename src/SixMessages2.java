class SixMessages2 {
    static void message() {
        System.out.println("Hello.");
        System.out.println("Hello.");
        System.out.println("Hello.");
    }
    public static void main(String[] args) {
        System.out.println("*** top ***");
        message();
        System.out.println("*** middle ***");
        message();
        System.out.println("*** end ***");
    }
}
