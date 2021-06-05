import org.graalvm.compiler.code.SourceStackTraceBailoutException;

class classfinal {
    protected void finalize() {
        System.out.println("finalizeメソッドが実行されました");
    }
}
public class Sample117 {
    public static void main(String[] args) {
        classfinal fin = new classfinal();
        fin = null;
        System.out.print("ガーベジコレクションを");
        System.out.println("強制的に実行します");
        System.gc();
    }
}
