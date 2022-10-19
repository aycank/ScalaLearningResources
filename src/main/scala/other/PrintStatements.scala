package other

object PrintStatements {
  def main(args: Array[String]): Unit = {
    val name : String = "Aycan"
    val age : Int = 24
    println("Name: " + name + "\nAge: " + age)
    println(s"$name is $age years old")         // print all in one
    println(f"$name%s is $age%d years old")     // format style, %s for string, %d is for integer, %f for float
    println(raw"Hello \n World")                // Prints literally, raw form
    printf("age is %d", age)
    println("")

    val version : String = util.Properties.versionString
    println(s"Name: $name\nVersion: $version")

  }
}
