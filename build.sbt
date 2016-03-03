name := "Pos"

version := "1.0"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  Resolver.typesafeRepo("releases")
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4" withSources()
)
