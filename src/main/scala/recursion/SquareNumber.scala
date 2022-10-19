package recursion

object SquareNumber {
  def main(args: Array[String]): Unit = {
    var result = functionExample(5)
    println(result)
  }

  def functionExample(a: Int): Int = if (a == 1) a else a * functionExample(a - 1)
}
