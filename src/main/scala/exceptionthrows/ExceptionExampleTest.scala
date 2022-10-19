package exceptionthrows

class ExceptionExample{
  @throws(classOf[NumberFormatException])
  def validate(): Int = {
    "abc".toInt
  }
}

object ExceptionExampleTest extends App{
  var e = new ExceptionExample()
  try{
    e.validate()
  }catch{
    case ex:NumberFormatException=> println("Number format issue")
  }
  println("rest of code is executing ")
}
