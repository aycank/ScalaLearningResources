package objectoriented

class StudentRecordOther (id : Int, name : String){
  def getRecord() : Unit = {
    println(id + "  "+ name)
  }
}

object Bruh extends App {
  var count = 0

  while(count < 5){
    val x = scala.io.StdIn.readInt()
    val y = scala.io.StdIn.readLine()
    val student = new StudentRecordOther(x, y)
    student.getRecord()
    count += 1
  }
}
