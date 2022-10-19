package objectoriented

import scala.io.StdIn.readLine

class StudentRecord(id : Int, name : String) {
  def getRecord() : Unit = {
    println("ID: " + id + "\nName: " + name)
  }
}

object MainObject extends App{
  println("What is your ID? ")
  var id = readLine().toInt
  println("What is your name? ")
  var name = readLine()
  var student = new StudentRecord(id, name)
  student.getRecord()
}
