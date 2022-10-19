ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "FirstSBTProject"
  )
val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
val utilControl = "org.scala-sbt" %% "util-control" % "1.7.2"
val alltests = "org.scalatest" %% "scalatest" % "3.2.14" % "test"
val mySQLDependency = "mysql" % "mysql-connector-java" % "8.0.30"
val bruh1 = "org.scalikejdbc" %% "scalikejdbc"       % "4.0.0"
val bruh2 = "com.h2database"  %  "h2"                % "1.4.200"
val bruh3 = "ch.qos.logback"  %  "logback-classic"   % "1.2.3"

libraryDependencies ++= Seq(utilControl,scalaLogging, alltests, mySQLDependency, bruh1, bruh2, bruh3)

