package collections

import scala.collection.immutable.SortedSet

object SortedSetExample extends App{
  val number: SortedSet[Int] = SortedSet(41, 12, 23, 43, 1, 72)
  number.foreach((elem:Int)=> println(elem))
}
