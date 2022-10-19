package higherorderfunctions

object VariableLengthParameters extends App{

  // For any length
  def add(args: Int*) : Int = {
    var sum = 0
    for(a <- args) sum += a
    sum
  }

  var sum = add(1,2,3,4,5,6,7,8,9)
  println(sum)
}
