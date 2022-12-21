val x1 = <a>This is some XML.Here is a tag: <atag/></a>

val yearMade = 1955
val x2 = <a> { if (yearMade < 2000) <old>{yearMade}</old> else xml.NodeSeq.Empty }</a>

val x3 = <a> {3 + 4} </a>

val x4 = <a> {"</a>potential security hole</a>"} </a>

val x5 = "<a>" + "</a>potential security hole</a>" + "</a>"

