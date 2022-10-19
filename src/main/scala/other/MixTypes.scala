package other

object MixTypes extends App {
  var result = search(4)
  //println(result)

  def search(a: Any): Any = a match {
    case 1 => println("Hi1");
    case 2 => println("Hi2");
    case 3 => println("Hi3");
    case 4 => println("Hi4");
    case _ => println("Hiii");
  }
}
