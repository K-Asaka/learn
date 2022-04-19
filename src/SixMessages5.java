class SixMessages5 {
    static void message(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello.");
        }
    }
    public static void main(String[] args) {
        System.out.println("*** top ***");
        message(2);
        System.out.println("*** middle ***");
        message(4);
        System.out.println("*** end ***");
    }
}
