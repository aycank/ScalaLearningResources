package other

object EvenOdd extends App {
  val i = 7;
  // Between 1 and 10
  i match {
    case 1 | 3 | 5 | 7 | 9 => println("odd");
    case 2 | 4 | 6 | 8 | 10 => println("even");

    case _ => println("Out of Bounds")
  }
}
