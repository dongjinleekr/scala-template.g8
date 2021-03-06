name := "$name$"

organization := "$organization$"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.10"

crossScalaVersions := Seq("2.11.8", "2.12.10")

val scalatestVersion = "3.0.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % scalatestVersion % Test
)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// sbt-sonatype configuration

homepage := Some(url("https://github.com/$github$/$name$"))
scmInfo := Some(ScmInfo(url("https://github.com/$github$/$name$"),
  "git@github.com:dongjinleekr/$name$.git"))
developers := List(Developer("username",
  "$author$",
  "$email$",
  url("https://github.com/$github$")))
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

packageOptions in(Compile, packageBin) +=
  Package.ManifestAttributes(new java.util.jar.Attributes.Name("Automatic-Module-Name") -> "com.dongjinlee.$name$")

