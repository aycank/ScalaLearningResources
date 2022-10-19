package inheritance

// Multiple level: a subclass inherits from more than one superclass indirectly.
// Multilevel (Seen here): the subclass inherits directly from more than one class.

trait A {
  var salary1 : Int = 10_000
}

class B extends A {
  var salary2 : Int = 20_000
}

class C extends B with A{
  def show(): Unit = {
    println(salary1)
    println(salary2)
  }
}

object MultiLevelInheritance extends App{
  var c = new C
  c.show()
}
