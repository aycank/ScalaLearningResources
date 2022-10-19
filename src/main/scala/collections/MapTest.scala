package collections

object MapTest extends App{
  var map = Map(("A","Apple"),("B", "Ball"))
  var map2 = Map("A" -> "Apple", "B" -> "Ball")
  var emptyMap : Map[String, String] = Map.empty[String, String]

  println(map)
  println(map2)
  println(emptyMap)

  println(map("B"))
  map2 = map2 + ("D" -> "Dog")
  println(map2)

  map2 = map2 - "B"
  println(map2)
}
