package polymorphism

class mathsComputation {
  def add(a: Int, b: Int): Unit = {
    val sum = a + b
    println(sum)
  }
  def add(a: Double, b: Double): Unit = {
    val sum = a + b
    println(sum)
  }

  def add(a: Int, b: Int, c: Int): Int = a + b + c
}
object Maintemp extends App{
  var a = new mathsComputation()
  a.add(1, 2)
  a.add(1.0, 2.0)
  println(a.add(1, 2, 3))
}
