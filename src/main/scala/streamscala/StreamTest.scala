package streamscala

// The Stream is a lazy lists where elements are evaluated only when they are needed

object StreamTest extends App{
  val stream : Stream[Int] = 1 #:: 2#:: 8#:: Stream.empty
  println(stream)

  print("Take first two numbers from stream: ")
  var a = stream.take(2).print()

  stream.take(10).print()
}
