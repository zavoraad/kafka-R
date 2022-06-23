ThisBuild / version      := "0.1.0"
ThisBuild / scalaVersion := "2.11.8"
ThisBuild / organization := "com.zavoraad"


lazy val root = (project in file("."))
  .settings(
    name         := "kafka-r",
    unmanagedResourceDirectories in Compile += baseDirectory.value / "resources",
    javacOptions ++= Seq("-source", "1.8"),
    libraryDependencies ++= Seq(
      "org.apache.kafka" % "kafka-clients" % "2.2.0",
    ),
    resolvers += Resolver.mavenLocal,
)
