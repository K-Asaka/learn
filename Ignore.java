import java.lang.annotation.*;      // これはJavaのコード
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Ignore { }
