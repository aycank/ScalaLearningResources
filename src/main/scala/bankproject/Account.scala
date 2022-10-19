package bankproject

import scala.util.Random

class Account(fName : String, lName : String) {
  private var balance: Double = 0
  private val sortCode: Int = Random.between(100000, 999999)
  private val accountNum: Int = Random.between(10000000, 99999999)

  def checkDetails(): Unit = println("Full Name: " + fName + " " + lName + "\nSort Code: " + sortCode +
    "\nAccount Number: " + accountNum)

  def checkBalance(): Unit = println("Balance: " + balance)

  def depositCash(): Unit = {
    println("How much money would you like to deposit?")
    val amount: Double = scala.io.StdIn.readDouble()
    var isDeposited: Boolean = false
    while (!isDeposited) {
      if (amount < 0) {
        println("Invalid amount.\n")
      } else {
        println(amount + " deposited.")
        balance += amount
        isDeposited = true
      }
    }
  }

  def withdrawCash(): Unit = {
    println("How much money would you like to withdraw?")
    val amount: Double = scala.io.StdIn.readDouble()
    if (amount < 0 || amount > balance) {
      println("Invalid Amount.")
    } else {
      balance -= amount
      println(amount + " withdrawn.")
    }
  }

  def transferCash(): Unit = {

  }

  class MainAcc extends Account(fName, lName) {
    def payOther(): Unit = {

    }
  }

  class SavingsAcc extends Account(fName, lName) {
    def getInterestRate(): Unit = {
    }

  }
}
