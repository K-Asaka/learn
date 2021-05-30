public class Sample072 {
    public static void main(String[] args) {
        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            System.out.print("例外" + e);
            System.out.println("を受け取りました");
        }
    }
}
