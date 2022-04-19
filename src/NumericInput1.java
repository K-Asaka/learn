class NumericInput1 {
    public static void main(String[] args) {
        int price = Integer.parseInt(args[0]);
        double taxRate = Double.parseDouble(args[1]);
        System.out.println("税込み価格は " + price * (1 + taxRate) + "円です。");
    }
}
