package activities

// All possible permutations of a string

object Activity8 extends App {
  def apply(text: String): Array[String] = text.permutations.toArray
  println(apply("aycan").mkString("\n"))
}
