public class DollarToYen1 {
    static double dollarToYen(double dollar, double rate) {
        return dollar * rate;
    }
    public static void main(String[] args) {
        double rate = 110.0;
        double dollar, yen;
        dollar = 2.0;
        yen = dollarToYen(dollar, rate);
        System.out.println(dollar + "ドル -> " + yen + "円");

        dollar = 4.0;
        yen = dollarToYen(dollar, rate);
        System.out.println(dollar + "ドル -> " + yen + "円");
    }
}
