package objectoriented

class Arithmetic {
  def add(x : Int, y : Int): Int = x + y
  def subtract(x : Int, y : Int) : Int = x - y
  def multiply(x : Int, y : Int) : Int = x * y
  def divide(x : Double, y : Double) : Double = x / y
  def square(x : Int) : Int = x * x
}

object Maths extends App{
  var answer = new Arithmetic
  println(answer.add(1, 3))
  println(answer.subtract(1, 3))
  println(answer.multiply(1, 3))
  println(answer.divide(5, 3))
  println(answer.square(2))
}
