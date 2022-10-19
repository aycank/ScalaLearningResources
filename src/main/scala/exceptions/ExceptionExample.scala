package exceptions

class ExceptionExample {
  def divide(a:Int, b:Int) : Unit = {
    try{
      println(a/b)
    } catch {
      case e: ArithmeticException => println(e)
    }
    println("Rest of code executing")
  }
}

object TempCheckException extends App{
  new ExceptionExample().divide(2, 0)
}
