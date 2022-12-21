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

object UpperCase {
    def unapply(s: String): Boolean = s.toUpperCase == s
}

def userTwiceUpper(s: String) = s match {
    case EMail(Twice(x @ UpperCase()), domain) =>
        "match: " + x + " in domain " + domain
    case _ =>
        "no match"
}

userTwiceUpper("DIDI@hotmail.com")
userTwiceUpper("DIDO@hotmail.com")
userTwiceUpper("didi@hotmail.com")

object Domain {
    // 注入メソッド(オプション)
    def apply(parts: String*): String =
        parts.reverse.mkString(".")
    
    // 抽出メソッド(必須)
    def unapplySeq(whole: String): Option[Seq[String]] =
        Some(whole.split("\\.").reverse.toSeq)
}

def isTomInDotCom(s: String): Boolean = s match {
    case EMail("tom", Domain("com", _*)) => true
    case _ => false
}

isTomInDotCom("tom@sun.com")
isTomInDotCom("peter@sun.com")
isTomInDotCom("tom@acm.org")
