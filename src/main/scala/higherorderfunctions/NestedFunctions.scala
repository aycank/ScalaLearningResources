package higherorderfunctions

object NestedFunctions extends App{
  def add(a:Int, b:Int, c:Int) : Int = {
    def add2(x: Int, y: Int): Int = x + y
    add2(a, add2(b, c))
  }
  var result = add(10, 10, 10)
  println(result)
}

