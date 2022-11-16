import java.nio.file.{Files, Paths, StandardOpenOption}
import scala.language.postfixOps
import scala.util.control.Breaks.break

package object counter {
  def compose: Int => Array[Int] = (num: Int) => {
    if (num < 1) {
      println("Given number is less than one.")
      break
    }
    // declare empty array for storing numbers
    val nums = new Array[Int](num)
    for (x <- 1 to num) {
      nums(x - 1) = x
    }
    nums
  }

  def writeToFile: (Int => Array[Int], Int) => Boolean = (compose, num) => {
    // output path -> $HOME
    val outputPath: String = sys.env("HOME") + "/numbers.txt"
    val nums: Array[Int] = compose(num)
    // loop through collected values
    // either create a new file and write values or append to existing file contents
    nums.foreach(num => Files.write(
      Paths.get(sys.env("HOME") + "/numbers.txt"), num.toString.getBytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND
    ))
    println(s"Output file path: $outputPath")
    true
  }
}