package arrays

class PracticeArray2{
  var arr = new Array[Int](5)
  def show(): Unit = {
    for(a<-arr){
      println(a)
    }
    println(arr(2))
    arr(2)=10
    println(arr(2))
  }
}

object PracticeArray2 extends App{
  var a = new PracticeArray2
  a.show()
}
