package exceptions

class Example2{
  def divide(a:Int,b:Int) = {
    try{
      println(a/b)
      val arr=Array(1,2)
      arr(1)
    } catch {
      case e:ArithmeticException => println(e)
      case e:Throwable => println(e)
    } finally {
      println("Code will run")
    }
    println("Done") //This will not run if error is not handled
  }

}

object ExceptionExample2 extends App{
  new Example2().divide(100,10)
}
