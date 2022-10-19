package activities

abstract class Donut(name: String){
  def printName(): Unit
}

case class VanillaDonut(name : String) extends Donut(name){
  override def printName() : Unit = println(name)
}

case class GlazedDonut(name : String) extends Donut(name){
  override def printName() : Unit = println(name)
}

class Pastry[P <: Donut](pastry: P){
  def name(): Unit = pastry.printName()
}

object AbstractDonut extends App{
  val vanillaDonut = VanillaDonut("Vanilla Donut")
  val glazedDonut = GlazedDonut("Glazed Donut")
  val vanillaPastry = new Pastry[VanillaDonut](vanillaDonut)
  vanillaPastry.name()
  val glazedPastry = new Pastry[Donut](glazedDonut)
  glazedPastry.name()
}
