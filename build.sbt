name := "Segral"

organization := "edu.neu.ise.cs"

version := "0.1"

scalaVersion := "2.10.3"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % "2.3.0",
                        "org.scala-lang" % "scala-actors" % "2.10.3",
                        "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test")
