package traitpractice

trait Print{
  def print()
}

abstract class PrintA4{
  def printA4()
}

class A6 extends PrintA4 {
  def print(): Unit = {
    println("Print sheet")
  }

  override def printA4(): Unit = {
    println("A4 Sheet")
  }
}

object MixTraits extends App{
  var a = new A6 with Print
  a.print()
  a.printA4()
}
