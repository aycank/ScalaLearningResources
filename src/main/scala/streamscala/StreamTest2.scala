package streamscala

import scala.collection.immutable.Stream.cons

object StreamTest2 extends App{
  val stream2 : Stream[Int] = cons(1,cons(10,cons(1000,Stream.empty)))
  println(s"Elements of stream ${stream2}")
}
