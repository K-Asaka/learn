public class ArrayFor3 {
    public static void main(String[] args) {
        int[] heiseis = {1, 5, 20, 29, 4, 9};
        for (int i = 0; i < heiseis.length; i++) {
            int seireki = heiseis[i] + 1988;
            System.out.println("平成" + heiseis[i] + "年 -> " + "西暦" + seireki + "年");
        }
    }
}
