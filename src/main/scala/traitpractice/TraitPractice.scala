package traitpractice

trait Printable{
  def Print()
}
class A4 extends Printable{
  override def Print() : Unit = {
    println("Its an A4 page")
  }
}

object TraitPractice extends App{
  var a : Printable = new A4()
  a.Print()
}
