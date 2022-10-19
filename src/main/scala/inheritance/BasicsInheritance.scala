package inheritance

object BasicsInheritance extends App{
  var businessMan = new BusinessPerson
  var programmer = new Programmer
  println(businessMan.toWork)
}
class Employee {
  val salary : Float = 50_000
  val toWork : String = "Working..."
}

class Programmer extends Employee{
  var bonus : Int = 5_000
}

class BusinessPerson extends Employee{
  var bonus : Int = 9_000
  override val toWork : String = "Pretending to work..."
}