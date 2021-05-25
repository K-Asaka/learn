import java.util.Calendar;

public class Sample036 {
    public static void main(String[] args) {
        Calendar Date1 = Calendar.getInstance();
        Date1.set(2001, 11, 10);
        Calendar Date2 = Calendar.getInstance();
        Date2.set(2001, 11, 11);
        Calendar Date3 = Calendar.getInstance();
        Date3.set(2001, 11, 11);

        System.out.print("2001/11/10は2001/11/11より後か？ ");
        System.out.println(Date1.after(Date2));
        System.out.print("2001/11/10は2001/11/11より前か？ ");
        System.out.println(Date1.before(Date2));
        System.out.print("2001/11/10と2001/11/11は同じか？ ");
        System.out.println(Date1.equals(Date2));
        System.out.print("2001/11/11と2001/11/11は同じか？ ");
        System.out.println(Date2.equals(Date3));
    }
}