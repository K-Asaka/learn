class Max6 {
    static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
    static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }
    static int max(int a, int b, int c, int d) {
        return max(max(a, b), max(c, d));
    }
    public static void main(String[] args) {
        System.out.println(max(-3, -4, -5));
        System.out.println(max(1, 2, 3, 4));
    }
}
