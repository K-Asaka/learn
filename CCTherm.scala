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
    
    def fromXML(node: scala.xml.Node): CCTherm =
        new CCTherm {
            val description = (node \ "description").text
            val yearMade = (node \ "yearMade").text
            val dateObtained = (node \ "dateObtained").text
            val bookPrice = (node \ "bookPrice").text.toInt
            val purchasePrice = (node \ "purchasePrice").text.toInt
            val condition = (node \ "condition").text.toInt
        }
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

val node = therm.toXML
fromXML(node)

scala.xml.XML.save("therm1.xml", node)

val loadnode = xml.XML.loadFile("therm1.xml")
fromXML(loadnode)


// 中括弧をScalaコードへのエスケープではなく、XMLテキストとして使いたい場合は単に2個の中括弧を続けて書けばよい
val p = <a> {{{{かっこ つけよう！}}}} </a>
