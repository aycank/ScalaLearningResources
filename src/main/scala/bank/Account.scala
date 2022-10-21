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

  /*
  If the user enters a specific account, they will be directed to this account start page. Here they can select
  between multiple options: Depositing money in to the account, withdrawing money out of the account, checking
  account balance, checking account details, and exiting back to the customer start page. Whatever they choose will
  call the respective function
   */
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

  /*
  Function to get the details of the account. It will print the account type (Checkings or Savings), Balance
  (2 decimal places)Account Number and Sort Code
   */
  def getDetails() : Unit = {
    println("---------------------------")
    println("Account Type: " + accType)
    println(f"Balance: $balance%1.2f")
    println("Account Number: " + accNum)
    println("Sort Code: " + sortCode)
  }

  /*
  Function to get simple details of the account, printing just the account type and balance (2 decimal places)
   */
  def getSimpleDetails() : Unit = {
    println("Account: " + accType + f"\tBalance: $balance%1.2f")
  }

  /*
  Function to get the id of the account
   */
  def getID: Int = id

  /*
  Function to get the current balance of the account (to 2 decimal places)
   */
  def getBalance() : Double = BigDecimal(balance).setScale(2, BigDecimal.RoundingMode.FLOOR).toDouble

  /*
  Function for depositing cash into the account. The user enters how much money they would like to deposit, as long
  as the value given is not less than or equal to 0. If the deposit is greater than 5000, then it will be flagged
  and logged in the log.txt. Otherwise it logs it normally and does not flag it. The deposit will be added to the
  total balance
   */
  def depositCash(customer: Customer) : Unit = {
    println("Enter how much to deposit: ")
    val deposit = readDouble()
    if(deposit <= 0) {
      println("Invalid Amount")
    }else {
      print(Thread.currentThread().getName + f" Is Going To Deposit $deposit%1.2f" + ". Please Wait.")
      try{
        Thread.sleep(1000) // 'Animation' to simulate the loading process of depositing money
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
      } catch {
        case ex: InterruptedException => println("Interrupted Exception") // Handling exceptions
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

  /*
  Function for withdrawing money out of the account. The user enters how much money they would like to withdraw, as long
  as the value given is not less than or equal to 0 AND after withdrawing, the balance isn't a negative value.
  If the withdraw is greater than 5000, then it will be flagged and logged in the log.txt. Otherwise it logs it
  normally and does not flag it. The withdraw will be deducted from the total balance
   */
  def withdrawCash(customer: Customer) : Unit = {
    println("Enter How Much To Withdraw: ")
    val withdraw = readDouble()
    if((withdraw <= 0) && (balance - withdraw < 0)){
      println("Invalid Amount")
    } else {
      print(Thread.currentThread().getName + f" Is Going To Withdraw $withdraw%1.2f" + ". Please Wait.")
      try{
        Thread.sleep(1000) // 'Animation' to simulate the loading process of withdrawing money
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

  /*
  Function to log everytime the customer deposits money into the account. This will be written in the log.txt file
   */
  def logDeposit(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Deposited " +
        "into Account: " + accType + "\n")
  }

  /*
  Function to log every time the customer withdraws money out of the account. This will be written in the log.txt file
   */
  def logWithdrawal(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Withdrew cash " +
        "from Account: " + accType + "\n")
  }

  /*
  Function to flag log if the customer has deposited more than 5000. This will be written in the log.txt file
   */
  def flagLogDeposit(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " FLAGGED Customer ID: " + customer.id + " (" + customer.getName() + ") Deposited more " +
        " than 5000 from Account: " + accType + "\n")
  }

  /*
  Function to flag log if the customer has withdrawn more than 5000. This will be written in the log.txt file
   */
  def flagLogWithdraw(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " FLAGGED Customer ID: " + customer.id + " (" + customer.getName() + ") Withdrew more " +
        " than 5000 from Account: " + accType + "\n")
  }
}
