class Max3 {
    static int max(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    public static void main(String[] args) {
        int ans;

        ans = max(1, 2);
        System.out.println(ans);
        
        System.out.println(max(-3, -4));
    }
}
