public class HeiseiToSeireki2 {
    public static void main(String[] args) {
        int heisei = 1;
        while (heisei <= 31) {
            System.out.println("平成" + heisei + "年 - " + "西暦" + (heisei + 1988) + "年");
            heisei++;
        }
    }
}
