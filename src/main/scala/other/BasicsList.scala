package other

object BasicsList extends App {
  var listOfNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  // Way 1
  BasicsList.listOfNumbers.foreach {
    println
  }
  // Way 2
  listOfNumbers.foreach(println)
  // Way 3
  listOfNumbers.foreach((x: Int) => println(x))

}
