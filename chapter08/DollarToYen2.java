public class DollarToYen2 {
    static final double RATE = 100;

    static double dollarToYen(double dollar, double rate) {
        return dollar * rate;
    }

    static double dollarToYen(double dollar) {
        return dollar * RATE;
    }
    public static void main(String[] args) {
        double dollar, yen, rate;
        dollar = 2.0;
        rate = 105;
        yen = dollarToYen(dollar, rate);
        System.out.println(dollar + "ドル -> " + yen + "円(為替レート:" + rate + ")");

        yen = dollarToYen(dollar);
        System.out.println(dollar + "ドル -> " + yen + "円(為替レート:" + RATE + ")");
    }
}
