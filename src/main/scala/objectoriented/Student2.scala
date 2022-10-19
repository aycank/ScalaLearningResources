package objectoriented

class Student2(id : Int, name : String) {
  def show(): Unit = {
    println("ID: " + id + "\nName: " + name)
  }
}

object ExecuteClass2 extends App {
  var s = new Student2(101, "Aycan")
  s.show()
}

