package pattern

// Used to create a class that can have only one instance that can be accessed globally
// If you want 1 object, its state should not change
object Singleton {
  def main(args: Array[String]): Unit = {
    SingletonObject.hello()
    SingletonObject.hello()
    SingletonObject.hello()
  }
}

object SingletonObject{
  var a = 2
  def hello(): Unit = {
    println("Hi " + a)
    a += 2
  }
}
