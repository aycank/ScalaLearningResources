package collections

object PriorityQueueTest extends App{
  case class Donut(name : String, price : Double)

  def donOrder(d:Donut) : Double = +d.price
  import scala.collection.mutable.PriorityQueue
  val priorityQueue : PriorityQueue[Donut] = PriorityQueue(
    Donut("Plain Donut", 1.50),Donut("Strawberry", 4.2), Donut("Chocolate",2.40))(Ordering.by(donOrder))

  println(s"element of pq are $priorityQueue")

  priorityQueue.enqueue(Donut("werwefwe",7.98))
  priorityQueue += Donut("werwefwe",7.98)

  var b: Donut = priorityQueue.dequeue()
  println(b.name)
}
