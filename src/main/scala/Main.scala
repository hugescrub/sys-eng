import counter._
import scala.io.StdIn

object Main extends App {

  print("Enter the value you want to count until: ")
  try {
    val num: Int = StdIn.readInt()
    writeToFile(compose, num)
  } catch {
    case e: NumberFormatException => println("Given input is not a number.")
  }
}
