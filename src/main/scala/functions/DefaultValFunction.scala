package functions

object DefaultValFunction {
  def main(args: Array[String]): Unit = {
    val result1 = functionExample(14, 23)
    val result2 = functionExample()
    val result3 = functionExample(4,_)
    val result4 = functionExample(b = 45)
    println(result1 + "\n" + result2 + "\n" + result3 + "\n" + result4)
  }

  def functionExample(a : Int = 5, b : Int = 0): Int = a + b
}
