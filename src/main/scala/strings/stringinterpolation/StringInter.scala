package strings.stringinterpolation

object StringInter extends App{
  new StringExample().show()
}

class StringExample {
  var s1 = "scala string example"
  var version = 2.1254
  def show() : Unit = {
    println(f"This is a $s1%s\nScala version is $version%2.2f")
  }
}
