import java.time.LocalDate;

public class Date5 {
    public static void main(String[] args) {
        // 今日の日付を生成
        LocalDate today = LocalDate.now();
        System.out.println(today.getDayOfWeek());
    }
}
