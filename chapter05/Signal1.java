public class Signal1 {
    public static void main(String[] args) {
        String color = "黄";
        if (color.equals("赤")) {
            System.out.println("止まれ");
        } else if (color.equals("青")) {
            System.out.println("進め");
        } else if (color.equals("黄")) {
            System.out.println("注意");
        } else {
            System.out.println("色名が不適切です");
        }
    }
}
