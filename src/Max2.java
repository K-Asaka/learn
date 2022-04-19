class Max2 {
    static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        int ans;

        ans = max(1, 2);
        System.out.println(ans);
        
        System.out.println(max(-3, -4));
    }
}
