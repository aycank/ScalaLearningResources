package activities

import scala.io.StdIn.readLine

// Check if number is positive or negative

object Activity1 extends App {
  print("Enter a Number: ")
  val number = readLine().toInt
  if (number >= 0) {
    println("Your number is Positive")
  } else {
    println("Your number is Negative")
  }
}
