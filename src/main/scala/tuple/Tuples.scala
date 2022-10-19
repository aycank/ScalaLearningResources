package tuple

object Tuples extends App {
  var tuple1 = (1,2,3,4,4,5,6)
  var tuple2 = ("Apple", "Oranges", "Bananas")
  var tuple3 = (2.3,4.5,5.6,7.8)
  var tuple4 = (1,2,5, 66, "India", 2.54)

  println(tuple1.productArity)
  println(tuple2._2.isInstanceOf[String])
  println(tuple3.getClass)
  println(tuple4.getClass)

}

