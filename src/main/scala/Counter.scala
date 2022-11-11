import java.nio.file.{Files, Paths, StandardOpenOption}
import scala.language.postfixOps

class Counter {

  def countUntilNum(num: Int): Boolean = {
    // output path -> $HOME
    val outputPath: String = sys.env("HOME") + "/numbers.txt"

    if (num < 1) {
      print("Given number is less than one.")
      return false
    }
    // declare empty array for storing numbers
    val nums: Array[Int] = new Array[Int](num)
    var i: Int = 0
    while (i < nums.length) for (x <- 1 to num) {
      nums(i) = x
      i += 1
    }
    // loop through collected values
    // either create a new file and write values or append to existing file contents
    nums.foreach(num => Files.write(
      Paths.get(outputPath), num.toString.getBytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND
    ))

    println("Output file path: " + outputPath)
    return true
  }
}

