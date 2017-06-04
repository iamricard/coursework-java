name := """coursework-java"""

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, SbtWeb)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  javaJdbc,
  cache,
  javaWs,
  evolutions,
  "org.postgresql" % "postgresql" % "42.1.1"
)

javaOptions ++= Seq("-javaagent:newrelic/newrelic.jar")
