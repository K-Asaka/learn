public class ArrayFor4 {
    public static void main(String[] args) {
        int[] heiseis = {1, 5, 20, 29};
        for (int hyear : heiseis) {
            int seireki = hyear + 1988;
            System.out.println("平成" + hyear + "年 -> " + "西暦" + seireki + "年");
        }
    }
}
