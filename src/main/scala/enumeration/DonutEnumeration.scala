package enumeration

object DonutEnumeration extends App {
  object Donut extends Enumeration {
    type Donut = Value

    val Glazed = Value("Glazed is for jjkl")
    val Strawberry = Value("Strawberry is for bruh")
    val Plain = Value("Plain is for y")
    val Vanilla = Value("Vanilla is for x")
  }
  println(s"Vanilla Donut => ${Donut.Vanilla}")
  println(s"Vanilla ID => ${Donut.Vanilla.id}")
  println(s"All Values => ${Donut.values}")

  Donut.values.foreach{
    case d if (d == Donut.Strawberry || d == Donut.Glazed) => println(s"Favorite keep it")
    case _ => println("Rejected"+_)
  }
}
