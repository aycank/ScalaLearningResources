package collections

import scala.collection.immutable.ListSet

object ListSet extends App{
  var listSet : ListSet[Int] =  scala.collection.immutable.ListSet(3,6,5,2,87,3,1)
  listSet.foreach((elem:Int) =>println(elem))
  println(listSet.isEmpty)
  listSet = listSet.empty
  println(listSet.isEmpty)
}
