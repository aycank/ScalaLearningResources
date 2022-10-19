package abstractclass

abstract class Bike(a : Int){
  var b : Int = 20
  var c : Int = 25
  def run()
  def performance() : Unit = {
    println("Performance Awesome")
  }
}

class Tesla(a : Int) extends Bike(a){
  c = 30
  override def run(): Unit = {
    println("running motor fine")
    println(a)
    println(b)
    println(c)
  }
}
object AbstractClassDetail extends App {
  var h = new Tesla(10)
  h.run()
  h.performance()
}
