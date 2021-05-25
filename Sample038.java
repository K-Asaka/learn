import java.util.Calendar;
import java.util.Date;

public class Sample038 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // 日付、時刻のチェックを厳密に行うかどうかを設定する
        cal.setLenient(false);
        // 2001年6月32日を指定
        cal.set(2001, 6, 32);
        try {
            Date date = cal.getTime();
        } catch (IllegalArgumentException e) {
            System.out.println("2001年6月32日は存在しません");
        }
    }
}
