import java.util.Calendar;

public class Sample033 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DATE);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        System.out.println("今日は");
        System.out.println(y + "年" + m + "月" + d + "日");
        System.out.println("です");
        System.out.println("時間は");
        System.out.println(h + "時" + min + "分" + sec + "秒");
        System.out.println("です");
    }
}
