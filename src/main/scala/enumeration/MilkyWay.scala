package enumeration

object MilkyWay extends Enumeration {
  type Planets = Value
  val Mercury, Venus, Earth, Jupiter, Saturn, Uranus, Neptune = Value

  val Pluto = Value(9,"Pluto")
  val Zoto = Value(10,"Zoto")

  def isMilkyWay(planets: Planets) : Unit = {
    println(s"Planet ${planets.id} and ${planets}")
  }

  def isPlanet(planet: Planets) : Unit = {
    val check = MilkyWay.values.toList.map(v => v.toString).contains(planet)
    println(s"Planet $planet belongs to milky way is ${check}")
  }

  def main(args: Array[String]): Unit = {
    println(s"The se of values of type planets that milkyway holds is ${MilkyWay.values}")

    isMilkyWay(MilkyWay.Mercury)
    isMilkyWay(MilkyWay.Earth)
    isMilkyWay(MilkyWay.Pluto)
    isMilkyWay(MilkyWay.Venus)

    isPlanet(MilkyWay.Venus)
  }
}
