package caseclass

trait Car

case class Volkswagen(a : Int, b : Int) extends Car
case class BMW(a : Int) extends Car
case object Tesla extends Car

object MainCaseClass extends App{
  callCase(Volkswagen(10,10))
  callCase(BMW(10))
  callCase(Tesla)

  def callCase(f : Car) : Unit = f match {
    case Volkswagen(f, g) => println("a =" + f + "b =" + g)
    case BMW(f) => println("a =" + f)
    case Tesla => println("No argument in case object")
  }
}
