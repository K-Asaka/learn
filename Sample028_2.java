public class Sample028_2 {
    public static void main(String[] args) {
        int i = 1;
        int j;

        outer: while (i <= 3) {
            i++;
            j = 0;
            while (j <= 5) {
                j++;
                if (j == 4) {
                    continue outer;
                }
                System.out.println(j);
            }
        }
    }
}
