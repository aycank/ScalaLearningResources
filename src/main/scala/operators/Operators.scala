package operators

object Operators extends App{
  //operands or instance variable
  var a= 4
  var b=2
  var c=true
  var d=false
  var result=0

  // Arithmetic operator a+b
  println("Addition is "+(a+b))

  println("Subtraction is "+(a-b))

  //relation operator
  if (a == b){
    println(" values are same")
  }else{
    println("values are not same")
  }

  //Logical operator
  println("Logical or of c || d is "+(c||d))

  //Bitwise AND operator
  result=a&b
  println("Bitwsie and "+result)

  //assignment operator
  println("Addition assignment is "+(a+=b))


  if (true && true){
    println("value")
  }

}
