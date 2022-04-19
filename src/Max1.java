class Max1 {
    static void max(int a, int b) {
        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        max(1, 2);
        max(-3, -4);        
    }
}