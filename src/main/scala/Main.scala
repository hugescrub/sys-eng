object Main extends App {
  val counter: Counter = new Counter

  print("Enter the value you want to count until: ")
  try {
    val num: Int = readInt()
    counter.countUntilNum(num)
  } catch {
    case e: NumberFormatException => print("Given input is not a number.")
  }
}
