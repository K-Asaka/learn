public class Signal2 {
    public static void main(String[] args) {
        String color = "赤";
        switch (color) {
            case "青":
                System.out.println("進め");
                break;
            case "赤":
                System.out.println("止まれ");
                break;
            case "黄":
                System.out.println("注意");
                break;
            default:
                System.out.println("信号にない色です");
        }
    }
}
