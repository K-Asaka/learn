import java.time.LocalDate;

public class Date4 {
    public static void main(String[] args) {
        // 今日の日付を生成
        LocalDate today = LocalDate.now();
        String todayStr = today.getYear() + "年" +
            today.getMonthValue() + "月" + today.getDayOfMonth() + "日";
            System.out.println(todayStr);
    }
}
