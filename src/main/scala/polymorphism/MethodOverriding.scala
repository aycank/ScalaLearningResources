package polymorphism

object MethodOverriding extends App{
  var v = new Vehicle
  var b = new Bike
  v.run()
  b.run()
}

class Vehicle{
  def run() : Unit = {
    println("Vehicle Running")
  }
}

class Bike extends Vehicle {
  override def run() : Unit = {
    //println("Bike Running")
    super.run() // Super looks at PARENT method and runs it
  }
}