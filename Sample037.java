import java.util.Calendar;

public class Sample037 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 1, 1);
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int last = cal.getActualMaximum(Calendar.DATE);
        System.out.print(y + "年" + m + "月の末日は ");
        System.out.println(last + "日です");
    }
}
