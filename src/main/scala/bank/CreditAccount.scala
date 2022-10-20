package bank

import scala.util.Random

class CheckingAccount(number : Int) extends Account {
  override val accNum : Int = Random.between(10000000, 99999999)
  override val id : Int = number
  override val accType: String = "Checking"
}
