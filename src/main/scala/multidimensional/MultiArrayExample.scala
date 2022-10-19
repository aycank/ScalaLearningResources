package multidimensional

object MultiArrayExample extends App{
  var a = new MultiArrayClass
  var b = new ArrayOfArray
  a.show
  b.show
}

class MultiArrayClass{
  var arr = Array.ofDim[Int](2,2)
  arr(1)(0) = 15
  def show : Unit = {
    for(i <- arr(0).indices; j <- arr(1).indices){
      print(" " + arr(i)(j))
    }
    println("")
  }
}

class ArrayOfArray{
  var arr = Array(Array(1,2,3,4,5),Array(6,7,8,9,10))
  def show : Unit = {
    for(i <- 0 to 1){
      for(j <- 0 to arr(1).length - 1){
        print(" " + arr(i)(j))
      }
      println("")
    }
    println("")
  }
}