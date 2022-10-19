package objectoriented

class Student {
  val id : Int = 50
  val name : String = "Mark"
}

object ExecuteClass extends App{
  var s = new Student()
  println("ID: " + s.id + "\nName: " + s.name)
}
