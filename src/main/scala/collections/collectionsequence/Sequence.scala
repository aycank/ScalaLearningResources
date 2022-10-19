package collections.collectionsequence

object Sequence extends App{
  var seq : Seq[Int] = Seq(52,8,9,4,21,5,1)
  seq.foreach((elem : Int) => println(elem))
  println("Second Index: "+ seq(2))
  println("Is it Empty: " + seq.isEmpty)
  println("Does it end with those values: " + seq.endsWith(Seq(8,3,7,1)))
  println("Does it contain that value: " + seq.contains(8))
  println("Index of that value: " + seq.lastIndexOf(1))
  println("Reversed: " + seq.reverse)
}
