package higherorderfunctions

import functions.Addition

object Composition {

  object Math {
    def add(x: Int, y: Int): Int = {
      return x + y
    }

    def subtract(x: Int, y: Int): Int = {
      x - y
    }

    def multiply(x: Int, y: Int): Int = x * y

    def divide(x: Double, y: Double): Double = x / y

    def square(x: Int) = x * x
  }

  def main(args: Array[String]): Unit = {
    println(Math.add(45, 50))
    println(Math.subtract(45, 50))
    println(Math.multiply(45, 50))
    println(Math.divide(45, 50))
    // If function has only 1 argument
    println(Math square 5)

    // From another file
    println(Addition.add(1, 2))
  }
}
