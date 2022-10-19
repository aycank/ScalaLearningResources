package activities

// Reverse integer digits

object Activity4 extends App {
  def reverseNum(x: Int): Int = {
    val toString : String = x.toString
    var result = ""
    for (i <- (0 until toString.length).reverse) {
      var ch = toString.charAt(i);
      result += ch
    }
    result.toInt
  }
  print("Enter a Number: ")
  val number = scala.io.StdIn.readInt()
  println("Reversed Number: " + reverseNum(number))
}
