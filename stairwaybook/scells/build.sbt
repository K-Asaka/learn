lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.stairwaybook",
      scalaVersion := "2.13.6"
    )),
    name := "scells"
  )
  
libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"
