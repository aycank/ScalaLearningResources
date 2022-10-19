package finaltest

class Vehicle{
  final val speed : Int = 60
  final def run() : Unit = {
    println("Yoo")
  }
}

class Bike extends Vehicle{
  // override val speed : Int = 100       CANNOT OVERRIDE A FINAL
  /*
  override def run() : Unit = {           ALSO CANNOT OVERRIDE METHODS
    println("Hii")
  }
   */
}

object FinalMain extends App{

}
