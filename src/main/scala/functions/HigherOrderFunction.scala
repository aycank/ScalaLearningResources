package functions

object HigherOrderFunction {
  def main(args: Array[String]): Unit = {
    //Addition
    val add = math(50, 20, (a, b) => a + b)
    val add2 = math(50, 20, _ + _)
    // Multiplication
    val multiply = math(50, 20, (a, b) => a * b)
    val multiply2 = math(50, 20, _ * _)
    // Min Value
    val min = math(50, 20, (a, b) => a min b)
    val min2 = math(50, 20, _ min _)

    println(add + "\n" + add2 + "\n" + multiply + "\n" + multiply2 + "\n" + min + "\n" + min2)
  }

  def math(a : Int, b : Int, f : (Int, Int) => Int) : Int = f(a, b)
}
