package lazyevaluation

// Expression isn’t evaluated until its first use
object LazyEvaluation extends App {
  // Only called when used
  lazy val myExpensiveValue = myExpensiveFunction()
  var settings: Boolean = true

  if (settings) {
    // Called here
    val temp = myExpensiveValue
    println("Aycan is " + temp)
  } else {
    println("Sleep")
  }


  def myExpensiveFunction(): Int = {
    println("Bruh")
    8
  }
}
