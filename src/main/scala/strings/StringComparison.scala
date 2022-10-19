package strings

class StringComparison {
  var s1 = "Scala String Example"
  var s2 = "Hello Scala"
  var s3 = "Hello Scala"
  var s4 = "Hello "
  var s5 = "Scala"
  var s6 = s4.concat(s5)
  def show() : Unit = {
    println(s1.compareTo(s2))  // Positive number means s1 is larger than s2, negative vice versa
    println(s2.compareTo(s3))
    println(s6.equals(s3))
    println(s1.substring(0,7))
    println(s1.codePointAt(2))
  }
}

object ClassExample extends App{
  new StringComparison().show()
}