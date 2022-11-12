Compile / mainClass := Some("Main")
packageBin / artifactName := {
  (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
    "exec.jar"
}
assembly / mainClass := Some("Main")
assembly / assemblyJarName := "exec.jar"
