name := "$name$"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
)

javacOptions ++= Seq("-source", "1.7")

// sbt-sonatype configuration

homepage := Some(url("https://github.com/dongjinleekr/$name$"))
scmInfo := Some(ScmInfo(url("https://github.com/dongjinleekr/$name$"),
  "git@github.com:dongjinleekr/$name$.git"))
developers := List(Developer("username",
  "Lee Dongjin",
  "dongjin@apache.org",
  url("https://github.com/dongjinleekr")))
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

organization := "com.dongjinlee"

description := "$description$"

packageOptions in(Compile, packageBin) +=
  Package.ManifestAttributes(new java.util.jar.Attributes.Name("Automatic-Module-Name") -> "com.dongjinlee.$name$")
