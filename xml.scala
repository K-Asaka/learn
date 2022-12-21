val x1 = <a>This is some XML.Here is a tag: <atag/></a>

val yearMade = 1955
val x2 = <a> { if (yearMade < 2000) <old>{yearMade}</old> else xml.NodeSeq.Empty }</a>

val x3 = <a> {3 + 4} </a>

val x4 = <a> {"</a>potential security hole</a>"} </a>

val x5 = "<a>" + "</a>potential security hole</a>" + "</a>"


val x6 = <a>Sounds <tag/> good</a>.text
val x7 = <a> input ---&gt; output </a>.text

val x8 = <a><B><c>hello</c></B></a> \ "b"

val x9 = <a><B><c>hello</c></B></a> \ "c"
val x10 = <a><B><c>hello</c></B></a> \\ "c"
val x11 = <a><B><c>hello</c></B></a> \ "a"
val x12 = <a><B><c>hello</c></B></a> \\ "a"

val joe = <employee
        name="Joe"
        rank="code monkey"
        serial="123"/>
joe \ "@name"
joe \ "@serial"


def proc(node: scala.xml.Node): String =
    node match {
        case <a>{contents @ _*}</a> => "It's an a: " + contents
        case <B>{contents @ _*}</B> => "It's a b: " + contents
        case _ => "It's something else."
    }

proc(<a>apple</a>)
proc(<B>banana</B>)
proc(<c>cherry</c>)

// @パターンを使って_*の結果値でcontents変数を束縛するとマッチする
proc(<a>a <em>red</em> apple</a>)
proc(<a/>)

val catalog =
    <catalog>
      <cctherm>
        <description>hot dog #5</description>
        <yearMade>1952</yearMade>
        <dateObtained>March 14, 2006</dateObtained>
        <bookPrice>2199</bookPrice>
        <purchasePrice>500</purchasePrice>
        <condition>9</condition>
      </cctherm>
      <cctherm>
        <description>Sprite Boy</description>
        <yearMade>1964</yearMade>
        <dateObtained>April 28, 2003</dateObtained>
        <bookPrice>1695</bookPrice>
        <purchasePrice>595</purchasePrice>
        <condition>5</condition>
      </cctherm>
    </catalog>

catalog match {
    case <catalog>{therms @ _*}</catalog> =>
        for (therm @ <cctherm>{_*}</cctherm> <- therms)
            println("processing: " + (therm \ "description").text)
}
