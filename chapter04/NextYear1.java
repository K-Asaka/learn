import java.time.LocalDate;

public class NextYear1 {
    public static void main(String[] args) {
        // 今日の日付を生成
        LocalDate today = LocalDate.now();
        // 来年の今日の日付を生成
        LocalDate nextYearDay = today.plusYears(1);
        // 来年の今日の日付を表示
        System.out.println(nextYearDay);
        // 来年の今日の曜日を表示
        System.out.println(nextYearDay.getDayOfWeek());
    }
}
