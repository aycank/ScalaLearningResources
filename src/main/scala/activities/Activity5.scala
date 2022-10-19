package activities

// Print the first and last digit of a number

object Activity5 extends App {
  def firstDigit(x: Int): Int = {
    var result: Int = x
    while (result >= 10) {
      result /= 10
    }
    result
  }

  def lastDigit(x: Int): Int = x % 10

  print("Enter a Number: ")
  var number = scala.io.StdIn.readInt()
  println("First Digit: " + firstDigit(number) + "\nLast Digit: " + lastDigit(number))
}
