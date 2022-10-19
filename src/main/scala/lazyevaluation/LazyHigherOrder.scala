package lazyevaluation

object LazyHigherOrder extends App{
  //define the function
  def function(f: => Int): Unit = {
    // i is not used first time
    lazy val i = f
    println(i + i)
  }
  //call the function
  function(15 / 5)
}
