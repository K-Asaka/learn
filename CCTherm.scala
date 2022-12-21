abstract class CCTherm {
    val description: String
    val yearMade: Int
    val dateObtained: String
    val bookPrice: Int          // 単位米国セント
    val purchasePrice: Int      // 単位米国セント
    val condition: Int          // コンディション(1から10まで)

    override def toString = description

    def toXML = 
        <cctherm>
            <description>{description}</description>
            <yearMade>{yearMade}</yearMade>
            <dateObtained>{dateObtained}</dateObtained>
            <bookPrice>{bookPrice}</bookPrice>
            <purchasePrice>{purchasePrice}</purchasePrice>
            <condition>{condition}</condition>
        </cctherm>
}

val therm = new CCTherm {
    val description = "hot dog #5"
    val yearMade = 1952
    val dateObtained = "March 14, 2006"
    val bookPrice = 2199
    val purchasePrice = 500
    val condition = 9
}

therm.toXML

// 中括弧をScalaコードへのエスケープではなく、XMLテキストとして使いたい場合は単に2個の中括弧を続けて書けばよい
val p = <a> {{{{かっこ つけよう！}}}} </a>
