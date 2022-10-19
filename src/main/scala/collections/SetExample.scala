package collections

// a Set is a collection that contains no duplicate elements

object SetExample extends App{
  var set1 = Set()  // Empty Set
  val games : Set[String] = Set("Cricket", "Football", "Hockey", "Golf", "Golf") // Does not allow duplicates
  val games2 : Set[String] = Set("Rugby")
  var numbers : Set[Int] = Set(2, 2, 3, 4)
  println(set1)
  println(games)
  println(numbers)
  println(games.head) // Head - First value
  println(games.tail) // Tail - Everything onwards after the first
  println(games.isEmpty)
  var together = games ++ games2
  println(together)
  together -= "Golf"
  println(together)
  println(" -------- ")
  together.foreach((elem:String) => println(elem))
  println(games & games2)
}
