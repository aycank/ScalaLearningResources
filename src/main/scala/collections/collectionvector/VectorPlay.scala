package collections.collectionvector

object VectorPlay extends App{
  var vector : Vector[Int] = Vector(5,2,7,9,1,8,10,3,1)
  var vector2 = Vector(2.4, 7, 1, 7)  // Auto converts to double
  var vector3 : Vector[String] = Vector.empty

  println(vector)
  println(vector2)
  println(vector3)

  //Append an element
  vector3 = vector3 :+ "Racing"
  println(vector3)
  println(vector3)

  var mergeVector = vector2 ++ vector3
  println(mergeVector)
  println(mergeVector.reverse)

  var forthVector = vector2.sorted
  println(forthVector)

  val from1to5 = 1 to 5
  println(s"$from1to5")
  from1to5.foreach(print(_))

  println()

  // Ordered
  val setFrom1to25Vector = (1 to 25).toVector
  println(setFrom1to25Vector)
  // Ordered
  val setFrom1to25Array = (1 to 25).toArray
  println(setFrom1to25Array.mkString("Array(", ", ", ")"))
  // Ordered
  val setFrom1to25List = (1 to 25).toList
  println(setFrom1to25List)
  // Unordered
  val setFrom1to25Set = (1 to 25).toSet
  println(setFrom1to25Set)
}
