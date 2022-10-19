package polymorphism

class Vehicles{
  val speed : Int = 60
}

class Plane extends Vehicles{
  // var tempSpeed = speed
  override val speed : Int = 100

  def show() : Unit ={
    println(speed)
    //println(tempSpeed)
  }
}

object FieldOverride extends App{
  var b = new Plane
  b.show()
}
