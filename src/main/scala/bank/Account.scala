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
        case 3 => println(getBalance())
        case 4 => getDetails()
        case 10 => println("Exiting...")
        case _ => println("Invalid Option")
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

  def getID: Int = id

  def getBalance() : Double = balance

  def depositCash(customer: Customer) : Unit = {
    println("Enter how much to deposit: ")
    val deposit = readDouble()
    if(deposit <= 0) {
      println("Invalid Amount")
    }else {
      println(Thread.currentThread().getName + " Is Going To Deposit £" + deposit + ". Please Wait...")
      try{
        Thread.sleep(3000)
      } catch {
        case ex: InterruptedException => println("Interrupted Exception")
      }
      balance += deposit
      println(deposit + " Deposited by " + Thread.currentThread().getName + ".\nThe New Balance is: " + balance)
      if(deposit <= 5000){
        logDeposit(customer)
      } else {
        flagLogDeposit(customer)
      }
    }
  }

  def withdrawCash(customer: Customer) : Unit = {
    println("Enter How Much To Withdraw: ")
    val withdraw = readDouble()
    if((withdraw <= 0) && (balance - withdraw < 0)){
      println("Invalid Amount")
    } else {
      println(Thread.currentThread().getName + " Is Going To Withdraw £" + withdraw + ". Please Wait...")
      try{
        Thread.sleep(3000)
      } catch{
        case ex: InterruptedException => println("Interrupted Exception")
      }
      balance -= withdraw
      println(withdraw + " Withdrawn.\nThe Remaining Balance is: " + balance + "" +
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

  def logDeposit(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Deposited " +
        "into Account: " + accType + "\n")
  }

  def logWithdrawal(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Withdrew cash " +
        "from Account: " + accType + "\n")
  }

  def flagLogDeposit(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " FLAGGED Customer ID: " + customer.id + " (" + customer.getName() + ") Deposited more " +
        " than 5000 from Account: " + accType + "\n")
  }

  def flagLogWithdraw(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " FLAGGED Customer ID: " + customer.id + " (" + customer.getName() + ") Withdrew more " +
        " than 5000 from Account: " + accType + "\n")
  }
}
