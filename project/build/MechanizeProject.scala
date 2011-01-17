import sbt.{ProjectInfo, DefaultProject}

class MechanizeProject(info: ProjectInfo) extends DefaultProject(info) {
  // val jbossReleases = "JBoss Releases" at "http://repository.jboss.org/maven2/"
  // val html5parser = "nu.validator.htmlparser" % "htmlparser" % "1.3"
  val httpclient = "org.apache.httpcomponents" % "httpclient" % "4.0.3"
  val specs = "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default"

  override def compileOptions = super.compileOptions ++ Seq(Unchecked)
}
