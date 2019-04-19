import sbt.Keys._
import sbt._
import sbtrelease.Version

name := "saveFile"

resolvers += Resolver.sonatypeRepo("public")
scalaVersion := "2.12.8"
releaseNextVersion := { ver => Version(ver).map(_.bumpMinor.string).getOrElse("Error") }
assemblyJarName in assembly := "saveInitialFile.jar"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-events" % "2.2.5",
  "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
  "com.github.seratch" %% "awscala-ec2" % "0.8.+",
  "com.github.seratch" %% "awscala-iam" % "0.8.+",
  "com.github.seratch" %% "awscala-dynamodb" % "0.8.+",
  "com.github.seratch" %% "awscala-emr" % "0.8.+",
  "com.github.seratch" %% "awscala-redshift" % "0.8.+",
  "com.github.seratch" %% "awscala-s3" % "0.8.+",
  "com.github.seratch" %% "awscala-simpledb" % "0.8.+",
  "com.github.seratch" %% "awscala-sqs" % "0.8.+",
  "com.github.seratch" %% "awscala-sts" % "0.8.+",
  "com.github.seratch" %% "awscala-stepfunctions" % "0.8.+"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings"
)
