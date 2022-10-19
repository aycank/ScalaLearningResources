package activities

import scala.io.StdIn.readLine

// Check if number is prime or not

object Activity2 extends App {
  def isPrime(x: Int): Boolean = {
    if (x <= 1) return false
    for (i <- 2 to x / 2) {
      if (x % i == 0) return false
    }
    true
  }

  print("Enter a number: ")
  val number = readLine().toInt
  if (isPrime(number)) println("Your number is prime!") else println("Your number is not prime")
}
