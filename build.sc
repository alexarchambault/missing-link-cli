import $ivy.`de.tototec::de.tobiasroeser.mill.vcs.version::0.4.1`

import de.tobiasroeser.mill.vcs.version.VcsVersion
import mill._
import mill.scalalib._
import mill.scalalib.publish._

object `missing-link` extends ScalaModule with PublishModule {
  def scalaVersion = "2.13.16"
  def ivyDeps = Agg(
    ivy"com.spotify:missinglink-core:0.2.11",
    ivy"com.github.alexarchambault::case-app:2.0.6"
  )

  def pomSettings = PomSettings(
    description = artifactName(),
    organization = "io.github.alexarchambault.plasmon",
    url = "https://github.com/alexarchambault/plasmon",
    licenses = Seq(License.`Apache-2.0`),
    versionControl = VersionControl.github("alexarchambault", "plasmon"),
    developers = Seq(
      Developer("alexarchambault", "Alex Archambault", "https://github.com/alexarchambault")
    ),
    packaging = "jar"
  )
  def publishVersion = VcsVersion.vcsState().format()
}
