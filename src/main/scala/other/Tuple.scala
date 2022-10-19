package other

object Tuple extends App {

  /*
  String
  Byte
  Short
  Char
  Int
  Long
  Float

   */


  val data = Map("Bruh" -> 21, "Moment" -> 7)

  case class Person(name: String, isAdult: Boolean)

  val createPerson: (String, Int) => Person = (name, age) => Person(name, age > 18)
  val users = data.map(createPerson.tupled)

  println(users)
}
