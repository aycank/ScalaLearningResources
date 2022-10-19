package activities

// List numbers from 100 to 150 (in a list)

object Activity7 extends App {
  val listRange = List.range(100, 151)
  val listRangeAsStr = listRange.mkString(", ")
  println(listRangeAsStr)
}
