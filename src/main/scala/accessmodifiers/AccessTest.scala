package accessmodifiers

//No Modifier / Public = Class(Yes), Companion(Yes), Subclass(Yes), Package(Yes), World(Yes)
//^ Least restrictive

//Protected = Class(Yes), Companion(Yes), Subclass(Yes), Package(No), World(No)
//^ More restrictive than public, but less so that private

//Private = Class(Yes), Companion(Yes), Subclass(No), Package(No), World(No)
//^ Most restrictive


class AccessExample{
  protected var a : Int = 10
}

class tempClass extends AccessExample{
  def display() : Unit = {
    println(a)
  }
}

object AccessTest extends App{
  var s = new tempClass
  s.display()
}
