package strings

class StringExample {
  var s1 = "Scala String Example"
  var s2 = "Hello Scala"
  var s3 = "Hello Scala"
  var s4 = 0
  def show(): Unit = {
    println(s1.equals(s2))
    println(s2.equals(s3))
    println(s2.toUpperCase().equals(s3.toLowerCase()))
  }
}

object StringExample extends App{
  new StringExample().show()
}
