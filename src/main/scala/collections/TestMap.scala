package collections

object TestMap extends App{
  val s1 = Set(5,1,3,7,9,2)
  val result = s1.map(x => x*x)
  println(result)

  val s2 = Set("Jinesh","bruh","moment","lolage")
  val result2 = s2.map(_.toUpperCase())
  println(result2)
}
