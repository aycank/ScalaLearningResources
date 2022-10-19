package bank

import scala.io.StdIn.{readDouble, readInt}
import scala.util.Random

abstract class Account {
  val id : Int
  val accNum : Int
  val accType : String
  private var balance : Double = 0
  private val sortCode : Int = Random.between(100000, 999999)

  def start() : Unit = {
    var choice : Int = 0
    while(choice != 10){
      println("1. Deposit to Account\n" +
        "2. Withdraw from Account\n" +
        "3. Check Account Balance\n" +
        "4. Check Details\n" +
        "10. Exit")
      choice = readInt()
      choice match{
        case 1 => //depositCash()
        case 2 => //withdrawCash()
        case 3 => //checkBalance()
        case 4 => //checkDetails()
        case 10 => start()
      }
    }
  }

  def getDetails() : Unit = {
    println("---------------------------")
    println("Account Type: " + accType)
    println("Balance: " + balance)
    println("Account Number: " + accNum)
    println("Sort Code: " + sortCode)
  }

  def getSimpleDetails() : Unit = {
    println("Account: " + accType + "\tBalance: " + balance)
  }

  def getID() : Int = id

  def getBalance() : Unit = println("Balance: " + balance)

  def depositCash() : Unit = {
    println("Enter how much to deposit: ")
    val deposit = readDouble()
    if(deposit <= 0) {
        println("Invalid Amount")
      } else {
      println(deposit + " Deposited.")
      balance += deposit
    }
  }

  def withdrawCash() : Unit = {
    println("Enter how much to Withdraw: ")
    val withdraw = readDouble()
    if(withdraw <= 0){
      println("Invalid Amount")
    } else {
      balance -= withdraw
      println(withdraw + " Withdrawn")
    }
  }

  def transferCash() : Unit = {

  }
}
