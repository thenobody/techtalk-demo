name := "techtalk-demo"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-context" % "4.1.6.RELEASE",
  "com.typesafe" % "config" % "1.3.0",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
)
    