public class Cast3 {
    public static void main(String[] args) {
        byte b1 = 10;
        int i1 = 2;
        int i2 = 5;
        double d1 = 5.5;
        b1 = (byte)i1;
        i2 = (int)d1;
        System.out.println("b1: " + b1);
        System.out.println("i2: " + i2);
    }
}
