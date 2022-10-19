package arrays

class PracticeArray {
  var arr: Array[Int] = Array(1,2,3,4,5,6,7,8,9)
  var arr1 = new Array[String](5)
  var arr2: Array[String] = new Array[String](5)
  def show(): Unit = {
    for(a<-arr) {
      println(a)
    }
    println("Third element: " + arr(2))
    println(arr.reverse.mkString("Array(", ",", ")"))
  }
}
object PracticeArray extends App{
  var prc = new PracticeArray
  prc.show()
}
