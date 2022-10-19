package collections

import scala.collection.immutable.Queue
object QueuePractice extends App{
  var queue = Queue(3,34,5,43,2,1,65)
  var queue2 : Queue[Int] = Queue(34,12,7,54,2)
  println(queue)
  println(queue2)

  var hi = queue.enqueue(10)
  println(hi)

  var bye = queue.dequeue
  println(bye)
}
