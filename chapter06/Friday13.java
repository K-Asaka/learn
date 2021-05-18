import java.time.DayOfWeek;
import java.time.LocalDate;

public class Friday13 {
    public static void main(String[] args) {
        // 今日の日付を生成
        LocalDate date = LocalDate.now();
        while (true) {
            date = date.plusMonths(1);
            date = date.withDayOfMonth(13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) break;
        }
        System.out.println(date);
    }
}
