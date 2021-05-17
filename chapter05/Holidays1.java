import java.time.LocalDate;

public class Holidays1 {
    public static void main(String[] args) {
        // 今日の日付を生成
        LocalDate today = LocalDate.now();
        switch (today.getDayOfWeek()) {
            case MONDAY:
            case TUESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("通常営業");
                break;
            case WEDNESDAY:
                System.out.println("午後のみ営業");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("休業");
        }
    }
}
