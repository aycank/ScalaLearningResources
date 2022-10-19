package activities

class Constructors{
  var fName : String = ""
  var lName : String = ""
  var age: Int = 0
  def show: Unit ={
    println("First Name: " + fName + "\nLast Name: " + lName + "\nAge: " + age)
  }
  def this(fName: String, lName: String, age : Int){
    this()
    this.fName = fName
    this.lName = lName
    this.age = age
  }
}

object Main extends App{
  var user = new Constructors("Michael", "Scott", 26)
  user.show
}