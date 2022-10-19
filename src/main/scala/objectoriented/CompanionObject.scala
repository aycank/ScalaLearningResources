package objectoriented

class CompanionClass {
  var a = 2
  def hello() : Unit = {
    println("This is a companion class" + a)
  }
}

object CompanionObject extends App {
  new CompanionClass().hello()
  new CompanionClass().hello()
  println("Companion Object")
}
