name := """coursework-java"""

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  jdbc,
  javaJdbc,
  cache,
  javaWs,
  evolutions,
  "org.postgresql" % "postgresql" % "42.1.1"
)

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}
