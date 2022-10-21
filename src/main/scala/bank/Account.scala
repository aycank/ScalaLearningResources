package bank

import org.joda.time.DateTime

import scala.io.StdIn.{readDouble, readInt}
import scala.util.Random

abstract class Account{
  val id : Int
  val accNum : Int
  val accType : String
  private var balance : Double = 0
  private val sortCode : Int = Random.between(100000, 999999)

  // Account Page Starting Hub
  def start(customer: Customer) : Unit = {
    var choice : Int = 0
    while(choice != 10){
      println("1. Deposit to Account\n" +
        "2. Withdraw from Account\n" +
        "3. Check Account Balance\n" +
        "4. Check Details\n" +
        "10. Exit")
      choice = readInt()
      choice match{
        case 1 => depositCash(customer)
        case 2 => withdrawCash(customer)
        case 3 => println("Balance: " + getBalance())
        case 4 => getDetails()
        case 10 => println("Exiting...")
        case _ => println("Invalid Option")
      }
    }
  }

  // Function to get Details for specific account type
  def getDetails() : Unit = {
    println("---------------------------")
    println("Account Type: " + accType)
    println(f"Balance: $balance%1.2f")
    println("Account Number: " + accNum)
    println("Sort Code: " + sortCode)
  }

  // Function to get simple Details for specific account type
  def getSimpleDetails() : Unit = {
    println("Account: " + accType + f"\tBalance: $balance%1.2f")
  }

  // Function to get ID
  def getID: Int = id

  // Function to get current balance
  def getBalance() : Double = BigDecimal(balance).setScale(2, BigDecimal.RoundingMode.FLOOR).toDouble

  // Function for depositing cash into account
  def depositCash(customer: Customer) : Unit = {
    println("Enter how much to deposit: ")
    val deposit = readDouble()
    if(deposit <= 0) {
      println("Invalid Amount")
    }else {
      print(Thread.currentThread().getName + f" Is Going To Deposit $deposit%1.2f" + ". Please Wait.")
      try{
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
      } catch {
        case ex: InterruptedException => println("Interrupted Exception")
      }
      balance += deposit
      println(f"$deposit%1.2f Deposited by " + Thread.currentThread().getName + f".\nThe New Balance is: $balance%1.2f")
      if(deposit <= 5000){
        logDeposit(customer)
      } else {
        flagLogDeposit(customer)
      }
    }
  }

  // Function for withdrawing cash out of account
  def withdrawCash(customer: Customer) : Unit = {
    println("Enter How Much To Withdraw: ")
    val withdraw = readDouble()
    if((withdraw <= 0) && (balance - withdraw < 0)){
      println("Invalid Amount")
    } else {
      print(Thread.currentThread().getName + f" Is Going To Withdraw $withdraw%1.2f" + ". Please Wait.")
      try{
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
      } catch{
        case ex: InterruptedException => println("Interrupted Exception")
      }
      balance -= withdraw
      println(f"$withdraw%1.2f Withdrawn.\nThe Remaining Balance is: $balance%1.2f" +
        "\nThe amount was taken by " + Thread.currentThread().getName)
      if(withdraw <= 5000){
        logWithdrawal(customer)
      } else {
        flagLogWithdraw(customer)
      }
    }
  }

  def transferCash() : Unit = {

  }

  // Function to log deposit
  def logDeposit(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Deposited " +
        "into Account: " + accType + "\n")
  }

  // Function to log withdrawing cash
  def logWithdrawal(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Withdrew cash " +
        "from Account: " + accType + "\n")
  }

  // Function to flag log if money deposited is over 5000
  def flagLogDeposit(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " FLAGGED Customer ID: " + customer.id + " (" + customer.getName() + ") Deposited more " +
        " than 5000 from Account: " + accType + "\n")
  }

  // Function to flag log if money withdrawn is over 5000
  def flagLogWithdraw(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " FLAGGED Customer ID: " + customer.id + " (" + customer.getName() + ") Withdrew more " +
        " than 5000 from Account: " + accType + "\n")
  }
}
