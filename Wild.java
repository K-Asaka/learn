// これはワイルドカード型を使ったJavaクラス
import java.util.*;

public class Wild {
    public Collection<?> contents() {
        Collection<String> stuff = new Vector<String>();
        stuff.add("a");
        stuff.add("b");
        stuff.add("see");
        return stuff;
    }
}
