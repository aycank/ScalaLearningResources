package higherorderfunctions

object AnonymousFunction extends App {
  var result1 = (a: Int, b: Int) => a + b
  println(result1(10, 20))

  var result2 = (_: Int) + (_: Int)
  println(result2(1, 2))
}
