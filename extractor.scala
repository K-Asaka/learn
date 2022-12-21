object EMail extends ((String, String) => String) {
    // 注入メソッド(オプション)
    def apply (user: String, domain: String) = user + "@" + domain

    // 抽出メソッド(必須)
    def unapply(str: String): Option[(String, String)] = {
        val parts = str split "@"
        if (parts.length == 2) Some(parts(0), parts(1)) else None
    }
}

object Twice {
    def apply(s: String): String = s + s
    def unapply(s: String): Option[String] = {
        val length = s.length / 2
        val half = s.substring(0, length)
        if (half == s.substring(length)) Some(half) else None
    }
}
