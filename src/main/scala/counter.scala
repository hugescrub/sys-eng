import java.nio.file.{Files, Paths, StandardOpenOption}
import scala.language.postfixOps
import scala.util.control.Breaks.break

package object counter {
  def compose: Int => Array[Int] = num => {
    if (num < 1) {
      println("Given number is less than one.")
      break
    }
    val nums = new Array[Int](num)
    for (x <- 1 to num) {
      nums(x - 1) = x
    }
    nums
  }

  def writeToFile: (Int => Array[Int], Int) => Boolean = (compose, num) => {
    val outputPath: String = sys.env("HOME") + "/numbers.txt"
    val nums: Array[Int] = compose(num)
    nums.foreach(num => Files.write(
      Paths.get(outputPath), (num.toString + ">").getBytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND
    ))
    println(s"Output file path: $outputPath")
    true
  }
}