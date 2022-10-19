package higherorderfunctions

object ScalaCurryingFunction extends App{
  // Technique of transforming a function that takes MULTIPLE arguments into a function that takes a SINGLE argument
  def add(x : Int, y : Int) : Int = x + y

  def add2(x : Int): Int => Int = (y : Int) => x + y

  def add3(x : Int) (y : Int): Int = x + y

  println(add(5, 6))

  println(add2(10)(20))
  val sum40 = add2(40)
  println(sum40(100))

  println(add3(100)(200))
  val sum50 = add3(50)_
  println(sum50(500))
}
