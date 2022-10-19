package collections.collectionbitset

// immutable - creates a copy with an extra value
// mutable - just adds it

import scala.collection.immutable.BitSet

object AddRemoveBitSet extends App{
  var numbers = BitSet(1,5,7,2,5,75,23,65,42)
  numbers.foreach((elem:Int)=>println(elem))
  numbers+=20
  println("After adding 20:\n"+numbers)
  numbers-=7
  println("After removing 7:\n"+numbers)
}
