import java.util.Date;

public class Sample034 {
    public static void main(String[] args) {
        int a = 0;

        // 処理開始時の時間を取得
        Date d = new Date();
        long sTime = d.getTime();

        // 処理時間を取得したい処理
        for (long i = 0; i < 100000000; i++) {
            a++;
            a--;
        }

        // 処理終了時の時間を取得
        d = new Date();
        long eTime = d.getTime();
        // 処理時間を計算
        System.out.println("処理時間は");
        System.out.println((eTime - sTime) + "ミリ秒です");
    }
}
