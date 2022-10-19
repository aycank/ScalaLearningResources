package constructor

class PrimaryConstructor(i : Int, name : String, swag : String) {
  def showDetails() : Unit = {
    println(i + " " + name + swag)
  }

}

object Temp extends App{
  var s = new PrimaryConstructor(1, "Bruh", "hello")
  s.showDetails()
}
