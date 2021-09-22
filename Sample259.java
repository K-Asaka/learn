import java.text.*;

public class Sample259 {
    public static void main(String[] args) {
        double num1 = 3.14159265358979;
        double num2 = 3141592;

        // DecimalFormatクラスのオブジェクトを作成
        DecimalFormat f = new DecimalFormat("0.000");

        System.out.println("デフォルトの書式で表示：" + num1);
        f.applyPattern("0.000");
        // 書式を設定して表示する
        System.out.println("書式「0.000」で表示：" + f.format(num1));

        System.out.println("デフォルトの書式で表示：" + num2);
        f.applyPattern("#,###");
        // 書式を設定して表示する
        System.out.println("書式「#,###」で表示：" + f.format(num2));
    }
}
