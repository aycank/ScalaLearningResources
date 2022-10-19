package abstractclass

abstract class Scooter(){
  def run()
}

class BMW extends Scooter{
  override def run():Unit = {
    println("Running motor fine")
  }
}

object AbstractClassMain extends App{
  var h = new BMW
  h.run()
}
