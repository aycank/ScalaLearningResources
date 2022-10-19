package constructor

// Manipulate data in an instance

class SecondaryConstructor(id : Int, name : String) {
  var age : Int = 0
  var temp : Int = 1

  def showDetails() : Unit = {
    println(id + "  " + name + "  " + age + "  " + temp)
  }

  def this(id : Int, name : String, age : Int){
    this(id ,name)
    this.age = age + 2
  }

  def this(id : Int, name : String, age : Int, temp : Int){
    this(id, name)
    this.temp = temp
    this.age = age + 4
  }
}
object hello extends App{
  var s = new SecondaryConstructor(1, "ram", 29)
  s.showDetails()
  println(s.age)

  var s1 = new SecondaryConstructor(1, "ram", 31, 56)
  s1.showDetails()
  println(s1.age)
}
