### Build with default sbt and run with Scala
1. [Install sbt](https://www.scala-sbt.org/download.html);
2. From project root - `sbt package` -> `cd target/scala-2.12` -> `scala run exec.jar`;
3. Or simply `sbt run` from project root.

### Build with sbt-assembly plugin and run with Java
1. From project root - `sbt assembly`;
2. `cd target/scala-2.12` -> `java -jar exec.jar`