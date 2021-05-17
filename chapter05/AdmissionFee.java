public class AdmissionFee {
    public static void main(String[] args) {
        int age = 15;
        int fee;
        if (age < 7 || age >= 60) {
            fee = 0;
        } else if (age < 13) {
            fee = 1000;
        } else {
            fee = 2000;
        }
        System.out.println("入場料: " + fee + "円");
    }
}
