public class Tax {
    public static void main(String[] args) {
        final double TAX_RATE = 0.1;
        // 税抜価格
        int price = 1050;
        // 税込価格
        int taxInPrice = (int)(price * (1 + TAX_RATE));
        System.out.println("税抜価格: " + price + "円");
        System.out.println("税込価格: " + taxInPrice + "円");
    }
}
