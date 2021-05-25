import java.util.Calendar;

public class Sample035 {
    static final String[] youbi = {
        "日", "月", "火", "水", "木", "金", "土"
    };

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DATE);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(y + "年" + m + "月" + d + "日は");
        System.out.println(youbi[w] + "曜日です");
    }
}
