package exceptionthrows

class InvalidAgeException(s:String) extends Exception{
  override def toString : String = super.toString + " ---- " + s
}

class InvalidGenderException(s:String) extends Exception{
  override def toString : String = super.toString + " ---- " + s
}


class ageCheck {
  @throws(classOf[InvalidAgeException])
  def validate(age:Int) : Unit = {
    if(age<18){
      throw new InvalidAgeException("Not Eligible")
    }else{
      println("You are eligible")
    }
  }
}

class genderType{
  @throws(classOf[InvalidGenderException])
  def validate(gender : String) : Unit = {
    if(gender != "boy" && gender != "girl"){
      throw new InvalidGenderException("Invalid Gender")
    } else {
      println("You are eligible")
    }
  }
}

object ExceptionExamples extends App{
  var e = new ageCheck()
  var g = new genderType()
  try{
    g.validate("boy")
    //e.validate(4)
  }catch{
    case e : Exception => println("Exception Occurred: " + e)
  }
}
