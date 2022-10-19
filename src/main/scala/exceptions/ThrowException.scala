package exceptions

class ThrowException {
  def validate(age:Int)={
    if(age<18)
      throw new ArithmeticException("You are not eligible")
    else
      println("You are eligible")
  }
}
object MainObject{
  def main(args:Array[String]): Unit ={
    val e=new ThrowException
    e.validate(10)
  }
}

