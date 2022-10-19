package other

import scala.io.StdIn.readLine
import scala.math.BigDecimal.double2bigDecimal

object Interactive extends App {
  print("Enter your first name: ")
  val firstName = readLine()
  print("Please enter your age: ")
  val age = readLine()

  println(s"Hello $firstName!\nWhat donut would you like? (Enter the letter)\nA) Chocolate Donut (£3.5 ea.)\nB) Vanilla Donut (£3 ea.)" +
    s"\nC) Glazed Donut (£2.5 ea.)")
  val donut = readLine()
  var donut_name: String = ""
  var donutChosen : Boolean = false
  while(donutChosen == false){
    if (donut == "A" || donut == "a") {
      donut_name = "Chocolate Donut"
      donutChosen = true;
    } else if (donut == "B" || donut == "b"){
      donut_name = "Vanilla Donut"
      donutChosen = true;
    } else if (donut == "C" || donut == "c"){
      donut_name = "Glazed Donut"
      donutChosen = true;
    } else println("Invalid donut")
  }
  println("Good choice! How many would you like?")
  val quantity = readLine().toInt
  var price : BigDecimal = 0;
  if(donut_name == "Chocolate Donut"){
    price = (quantity * 3.5).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }else if(donut_name == "Vanilla Donut"){
    price = (quantity * 3.0).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }else{
    price = (quantity * 2.5).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
  println(s"That will cost you $price pounds!")
  println(s"Thank you! Here is your receipt:\n{\n\t\"donut_name\":\"$donut_name\",\n\t\"quantity_purchased\":\"$quantity\",\n\t\"Price\":\"$price\"\n}")
}
